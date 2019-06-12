package ru.ssu.csit.spring.homework.model;

public enum Cabinet {
    Room1(1),
    Room2(2),
    Room3(3);

    private final int value;

    Cabinet(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
