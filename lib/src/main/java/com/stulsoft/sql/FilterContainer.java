package com.stulsoft.sql;

import java.util.ArrayList;
import java.util.List;

public class FilterContainer {
    private final List<FilterElement> filterElements = new ArrayList<>();

    public List<FilterElement> getFilterElements() {
        return new ArrayList<>(filterElements);
    }

    @Override
    public String toString() {
        return "FilterContainer{" +
                "filterElements=" + filterElements +
                '}';
    }

    public FilterContainer addFilterElement(FilterElement filterElement) throws Exception {
        if (filterElements.isEmpty() && filterElement instanceof Operator) {
            throw new Exception("First element could not be Operator. " + filterElement);
        }

        FilterElement lastFilterElement = lastFilterElement();
        if ((lastFilterElement instanceof Operator) && (filterElement instanceof Operator)) {
            throw new Exception("Filter element could not be Operator. " + filterElement);
        }

        filterElements.add(filterElement);
        return this;
    }

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        if (filterElements.isEmpty()) {
            return stringBuilder.toString();
        }

        for (FilterElement filterElement : filterElements) {
            if (filterElement instanceof Operator) {
                stringBuilder.append(' ');
                stringBuilder.append(filterElement);
            }

            if (filterElement instanceof SingleFilter) {
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append(((SingleFilter) filterElement).filterExpression());
            }
        }
        return stringBuilder.toString();
    }

    private FilterElement lastFilterElement() {
        return filterElements.isEmpty() ? null : filterElements.get(filterElements.size() - 1);
    }
}
