package ru.ssu.csit.spring.homework.view;

import ru.ssu.csit.spring.homework.model.Cabinet;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransferCabinetView {
    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    private Cabinet cabinet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }
}
