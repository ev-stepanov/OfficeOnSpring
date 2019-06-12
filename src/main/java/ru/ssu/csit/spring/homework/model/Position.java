package ru.ssu.csit.spring.homework.model;

public enum Position {
    Junior(1),
    Middle(2),
    Senior(3);

    private final int value;

    Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
