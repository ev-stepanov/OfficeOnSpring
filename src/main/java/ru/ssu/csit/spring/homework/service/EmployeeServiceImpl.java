package ru.ssu.csit.spring.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ssu.csit.spring.homework.dao.EmployeeDao;
import ru.ssu.csit.spring.homework.dao.EmployeeDaoImpl;
import ru.ssu.csit.spring.homework.exception.NotCompletedException;
import ru.ssu.csit.spring.homework.exception.RecordNotFoundException;
import ru.ssu.csit.spring.homework.mapper.MapperFacade;
import ru.ssu.csit.spring.homework.model.Employee;
import ru.ssu.csit.spring.homework.view.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final MapperFacade mapperFacade;
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao, MapperFacade mapperFacade) {
        this.employeeDao = employeeDao;
        this.mapperFacade = mapperFacade;
    }

    @Transactional
    public List<NamesOfAllEmployeesView> listNames() {
        return mapperFacade.mapAsList(employeeDao.getAllEmployees(), NamesOfAllEmployeesView.class);
    }

    @Transactional
    public List<AllInformationAboutEmployeesView> detailedList() {
        List<Employee> employees = employeeDao.getAllEmployees();
        List<AllInformationAboutEmployeesView> allInformationAboutEmployees = mapperFacade.mapAsList(employees, AllInformationAboutEmployeesView.class);

        for (int i = 0; i < allInformationAboutEmployees.size(); i++) {
            long age = ChronoUnit.YEARS.between(employees.get(i).getBirthday(), LocalDate.now());
            allInformationAboutEmployees.get(i).setAge(age);
        }
        return allInformationAboutEmployees;
    }

    @Transactional
    public InformationAboutEmployeeView getById(Long id) throws RecordNotFoundException {
        Employee employee = employeeDao.getById(id);
        if (employee == null) {
            throw new RecordNotFoundException("Employee with id = " + id + " was not found.");
        }
        InformationAboutEmployeeView employeeView = mapperFacade.map(employee, InformationAboutEmployeeView.class);
        employeeView.setDate(employee.getBirthday());
        return employeeView;
    }

    @Transactional
    public List<InformationAboutEmployeeView> getByNames(FilterNamesView filterNamesView) throws RecordNotFoundException {
        List<Employee> employeeList = employeeDao.getByNames(filterNamesView.getFirstName(), filterNamesView.getSecondName());
        List<InformationAboutEmployeeView> employeeViews = mapperFacade.mapAsList(employeeList, InformationAboutEmployeeView.class);

        if (employeeViews.isEmpty()) {
            throw new RecordNotFoundException("Employees with first name: " + filterNamesView.getFirstName() +
                    " and second name: " + filterNamesView.getSecondName() + " does not exist.");
        }
        for (int i = 0; i < employeeViews.size(); i++) {
            employeeViews.get(i).setDate(employeeList.get(i).getBirthday());
        }
        return employeeViews;
    }

    @Transactional
    public void save (NewEmployeeView newEmployeeView) throws NotCompletedException {
        Employee employee = mapperFacade.map(newEmployeeView, Employee.class);
        long year = ChronoUnit.YEARS.between(employee.getBirthday(), LocalDate.now());
        if (year < 10 || year > 140) {
            throw new NotCompletedException("Wrong date.");
        }
        employeeDao.save(employee);
    }

    @Transactional
    public void addEmployeeOnProject(EmployeeOnProjectView employeeOnProjectView) throws RecordNotFoundException, NotCompletedException {
        Employee employee = employeeDao.getById(employeeOnProjectView.getId());
        if (employee == null) {
            throw new RecordNotFoundException("Employee with id = " + employeeOnProjectView.getId() + " was not found.");
        }
        if (employee.getProjects().contains(employeeOnProjectView.getProject())) {
            throw new NotCompletedException("Employee is already working on this project");
        }
        employee.getProjects().add(employeeOnProjectView.getProject());
    }

    @Transactional
    public void dismissEmployeeFromProject(EmployeeOnProjectView employeeOnProjectView) throws NotCompletedException, RecordNotFoundException {
        Employee employee = employeeDao.getById(employeeOnProjectView.getId());
        if (employee == null) {
            throw new RecordNotFoundException("Employee with id = " + employeeOnProjectView.getId() + " was not found.");
        }
        if (!employee.getProjects().contains(employeeOnProjectView.getProject())) {
            throw new NotCompletedException("Employee is already not working on this project");
        }
        employee.getProjects().remove(employeeOnProjectView.getProject());
    }

    @Transactional
    public void salaryIncrease(SalaryIncreaseView salaryIncreaseView) throws RecordNotFoundException, NotCompletedException {
        Employee employee = employeeDao.getById(salaryIncreaseView.getId());
        if (employee == null) {
            throw new RecordNotFoundException("Employee with id = " + salaryIncreaseView.getId() + " was not found.");
        }
        if (employee.getSalary() >= salaryIncreaseView.getSalary()) {
            throw new NotCompletedException("You can not reduce wage.");
        }
        employee.setSalary(salaryIncreaseView.getSalary());
    }

    @Transactional
    public void transferToAnotherCabinet(TransferCabinetView transferCabinetView) throws RecordNotFoundException {
        Employee employee = employeeDao.getById(transferCabinetView.getId());
        if (employee == null) {
            throw new RecordNotFoundException("Employee with id = " + transferCabinetView.getId() + " was not found.");
        }
        employee.setCabinet(transferCabinetView.getCabinet());
    }

    @Transactional
    public void removeEmployee(RemoveEmployeeView removeEmployeeView) throws NotCompletedException {
        employeeDao.remove(removeEmployeeView.getId());
    }
}