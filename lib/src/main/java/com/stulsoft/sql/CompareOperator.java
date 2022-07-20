package com.stulsoft.sql;

public enum CompareOperator {
    EQUAL("="), NOT_EQUAL("!="), LIKE("LIKE");

    public final String value;

    private CompareOperator(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
