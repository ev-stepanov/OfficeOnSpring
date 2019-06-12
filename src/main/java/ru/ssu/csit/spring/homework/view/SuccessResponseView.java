package ru.ssu.csit.spring.homework.view;

public class SuccessResponseView {
    private String result;

    public SuccessResponseView(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
