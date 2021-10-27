package com.elombard.model.enums;

public enum Status {
    OPEN("Открыт"),
    GUARANTEE_PERIOD("Гарантийный срок"),
    REALIZATION("На реализации"),
    CLOSED("Полный возврат кредита"),
    PROLONGED("Пролонгирован");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


}
