package ru.ssu.csit.spring.homework.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.ssu.csit.spring.homework.model.Cabinet;
import ru.ssu.csit.spring.homework.model.Project;
import ru.ssu.csit.spring.homework.model.Position;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllInformationAboutEmployeesView {
    private Long id;
    private String firstName;
    private String secondName;
    private String middleName;
    private Long age;
    private String email;
    private Long salary;
    private List<Project> projects;
    private Position position;
    private Cabinet cabinet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }
}
