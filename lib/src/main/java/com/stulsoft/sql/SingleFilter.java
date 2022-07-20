package com.stulsoft.sql;

public class SingleFilter implements Filter{
    private final String columnName;
    private final CompareOperator compareOperator;
    private final Object value;

    public SingleFilter(String columnName, CompareOperator compareOperator, Object value) {
        this.columnName = columnName;
        this.compareOperator = compareOperator;
        this.value = value;
    }

    @Override
    public String filterExpression() {
        if (value instanceof String) {
            return String.format("%s %s '%s'", columnName, compareOperator.value, value);
        } else {
            return String.format("%s %s %s", columnName, compareOperator.value, value);
        }
    }

    @Override
    public String toString() {
        return "SingleFilter{" +
                "columnName='" + columnName + '\'' +
                ", compareOperator=" + compareOperator +
                ", value=" + value +
                '}';
    }
}
