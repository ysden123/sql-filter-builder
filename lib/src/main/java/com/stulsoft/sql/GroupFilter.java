package com.stulsoft.sql;

import java.util.List;

public class GroupFilter extends Filter {
    private final List<Filter> filters;

    public GroupFilter(Operator operator, List<Filter> filters) {
        super(operator);
        this.filters = filters;
    }

    @Override
    public String filterExpression() {
        if (filters.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder("(");
        for (int i = 0; i < filters.size(); ++i) {
            Filter filter = filters.get(i);
            if (i != 0) {
                stringBuilder.append(' ');
                stringBuilder.append(filter.getOperator());
                if (i < filters.size()) {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append(filter.filterExpression());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
