package ru.ssu.csit.spring.homework.model;

public enum Project {
    Google(1),
    Apple(2),
    Microsoft(3);

    private final int value;

    Project(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
