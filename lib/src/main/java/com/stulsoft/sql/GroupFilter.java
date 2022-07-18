package com.stulsoft.sql;

import java.util.List;

public class GroupFilter implements Filter {
    private final Operator operator;
    private final FilterContainer filterContainer;

    public GroupFilter(Operator operator, FilterContainer filterContainer) {
        this.operator = operator;
        this.filterContainer = filterContainer;
    }

    @Override
    public String filterExpression() {
        StringBuilder stringBuilder = new StringBuilder();
        List<FilterElement> filterElements = filterContainer.getFilterElements();
        if (!filterElements.isEmpty()) {
            stringBuilder.append(" ");
            stringBuilder.append(operator);
            stringBuilder.append(" (");
            stringBuilder.append(filterContainer.build());
            stringBuilder.append(')');
        }

        return stringBuilder.toString();
    }
}
