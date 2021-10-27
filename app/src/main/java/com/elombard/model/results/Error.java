package com.elombard.model.results;

public class Error {
    int code;
    String text;

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", text='" + text + '\'' +
                '}';
    }
}
