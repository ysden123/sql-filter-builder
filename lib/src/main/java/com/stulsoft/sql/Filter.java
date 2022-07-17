package com.stulsoft.sql;

public abstract class Filter {
    private final Operator operator;

    public Filter(Operator operator) {
        this.operator = operator;
    }

    public abstract String filterExpression();

    public Operator getOperator() {
        return operator;
    }
}
