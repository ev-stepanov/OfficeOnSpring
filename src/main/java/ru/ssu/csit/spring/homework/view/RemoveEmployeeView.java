package ru.ssu.csit.spring.homework.view;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RemoveEmployeeView {
    @NotNull
    @Min(1)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
