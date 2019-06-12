package ru.ssu.csit.spring.homework.view;

public class ErrorResponseView {
    private String error;

    public ErrorResponseView(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
