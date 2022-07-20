package com.stulsoft.sql;

public class SingleFilter implements Filter{
    private String columnName;
    private CompareOperator compareOperator;
    private Object value;

    private SingleFilter(){

    }

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
