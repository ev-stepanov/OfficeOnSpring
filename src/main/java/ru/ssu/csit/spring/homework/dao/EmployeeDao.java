package ru.ssu.csit.spring.homework.dao;

import ru.ssu.csit.spring.homework.exception.NotCompletedException;
import ru.ssu.csit.spring.homework.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getById(Long id);
    List<Employee> getByNames(String firstName, String secondName);
    void save(Employee employee);
    void remove(Long id) throws NotCompletedException;
}
