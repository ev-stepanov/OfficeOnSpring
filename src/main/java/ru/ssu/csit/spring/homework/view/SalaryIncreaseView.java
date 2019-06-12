package ru.ssu.csit.spring.homework.view;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SalaryIncreaseView {
    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @Min(0)
    private Long salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
