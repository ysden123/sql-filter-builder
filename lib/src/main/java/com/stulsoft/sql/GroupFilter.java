package com.stulsoft.sql;

import java.util.List;

public class GroupFilter implements Filter {
    private FilterContainer filterContainer;

    private GroupFilter(){

    }

    public GroupFilter(FilterContainer filterContainer) {
        this.filterContainer = filterContainer;
    }

    @Override
    public String filterExpression() {
        StringBuilder stringBuilder = new StringBuilder();
        List<FilterElement> filterElements = filterContainer.getFilterElements();
        if (!filterElements.isEmpty()) {
            stringBuilder.append("(");
            stringBuilder.append(filterContainer.build());
            stringBuilder.append(')');
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "GroupFilter{" +
                "filterContainer=" + filterContainer +
                '}';
    }
}
