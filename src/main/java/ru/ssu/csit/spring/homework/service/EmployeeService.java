package ru.ssu.csit.spring.homework.service;

import org.springframework.validation.annotation.Validated;
import ru.ssu.csit.spring.homework.exception.NotCompletedException;
import ru.ssu.csit.spring.homework.exception.RecordNotFoundException;
import ru.ssu.csit.spring.homework.view.*;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface EmployeeService {
    List<NamesOfAllEmployeesView> listNames();
    List<AllInformationAboutEmployeesView> detailedList();
    InformationAboutEmployeeView getById(Long id) throws RecordNotFoundException;
    List<InformationAboutEmployeeView> getByNames(@Valid FilterNamesView filterNamesView) throws RecordNotFoundException;
    void save (@Valid NewEmployeeView newEmployeeView) throws NotCompletedException;
    void addEmployeeOnProject(@Valid EmployeeOnProjectView employeeOnProjectView) throws RecordNotFoundException, NotCompletedException;
    void dismissEmployeeFromProject(@Valid EmployeeOnProjectView employeeOnProjectView) throws NotCompletedException, RecordNotFoundException;
    void salaryIncrease(@Valid SalaryIncreaseView salaryIncreaseView) throws RecordNotFoundException, NotCompletedException;
    void transferToAnotherCabinet(@Valid TransferCabinetView transferCabinetView) throws RecordNotFoundException;
    void removeEmployee(@Valid RemoveEmployeeView removeEmployeeView) throws NotCompletedException;
}
