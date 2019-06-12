package ru.ssu.csit.spring.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ssu.csit.spring.homework.exception.NotCompletedException;
import ru.ssu.csit.spring.homework.exception.RecordNotFoundException;
import ru.ssu.csit.spring.homework.service.EmployeeService;
import ru.ssu.csit.spring.homework.service.EmployeeServiceImpl;
import ru.ssu.csit.spring.homework.view.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/list")
    public List<NamesOfAllEmployeesView> listAllEmployeesNames () {
        return employeeService.listNames();
    }

    @GetMapping(value = "/detailed_list")
    public List<AllInformationAboutEmployeesView> listAllEmployee () {
        return employeeService.detailedList();
    }

    @GetMapping(value = "/id/{id:[\\d]+}")
    public InformationAboutEmployeeView getEmployeeById (@PathVariable("id") Long id) throws RecordNotFoundException {
        return employeeService.getById(id);
    }

    @PostMapping(value = "/filter")
    public List<InformationAboutEmployeeView> getUserByName (@RequestBody FilterNamesView filterNamesView) throws RecordNotFoundException {
        return employeeService.getByNames(filterNamesView);
    }

    @PostMapping(value = "/save")
    public void save (@RequestBody NewEmployeeView newEmployeeView) throws NotCompletedException {
        employeeService.save(newEmployeeView);
    }

    @PostMapping(value = "/add_on_project")
    public void addEmployeeOnProject(@RequestBody EmployeeOnProjectView employeeOnProjectView) throws RecordNotFoundException, NotCompletedException {
        employeeService.addEmployeeOnProject(employeeOnProjectView);
    }

    @PostMapping(value = "/dismiss_with_project")
    public void dismissEmployeeFromProject(@RequestBody EmployeeOnProjectView employeeOnProjectView) throws NotCompletedException, RecordNotFoundException {
        employeeService.dismissEmployeeFromProject(employeeOnProjectView);
    }

    @PostMapping(value = "/salary_increase")
    public void salaryIncrease (@RequestBody SalaryIncreaseView salaryIncreaseView) throws RecordNotFoundException, NotCompletedException {
        employeeService.salaryIncrease(salaryIncreaseView);
    }

    @PostMapping(value = "/transfer_classroom")
    public void transferToAnotherClassroom (@RequestBody TransferCabinetView transferCabinetView) throws RecordNotFoundException {
        employeeService.transferToAnotherCabinet(transferCabinetView);
    }

    @PostMapping(value = "/remove_employee")
    public void removeEmployee(@RequestBody RemoveEmployeeView removeEmployeeView) throws NotCompletedException {
        employeeService.removeEmployee(removeEmployeeView);
    }
}
