package ru.ssu.csit.spring.homework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ssu.csit.spring.homework.exception.NotCompletedException;
import ru.ssu.csit.spring.homework.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private final EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List<Employee> getAllEmployees() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employeeRoot);
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> getByNames(String firstName, String secondName) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        Predicate predicate = criteriaBuilder.equal(employeeRoot.get("firstName"), firstName);
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(employeeRoot.get("secondName"), secondName));

        criteriaQuery.select(employeeRoot).where(predicate);
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public void save(Employee employee){
        em.persist(employee);
    }

    public void remove(Long id) throws NotCompletedException {
        Employee employee = em.find(Employee.class, id);
        if (employee == null) {
            throw new NotCompletedException("Employee with id = " + id + " not exist.");
        }
        em.remove(employee);
    }
}