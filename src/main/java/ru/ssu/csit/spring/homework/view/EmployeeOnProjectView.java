package ru.ssu.csit.spring.homework.view;

import ru.ssu.csit.spring.homework.model.Project;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmployeeOnProjectView {
    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
