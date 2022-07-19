package com.stulsoft.sql;

import java.util.ArrayList;
import java.util.List;

public class WhereBuilder {
    private final List<FilterElement> filterElements = new ArrayList<>();

    WhereBuilder addFilterElement(FilterElement filterElement) throws Exception {
        if (filterElements.isEmpty() && filterElement instanceof Operator) {
            throw new Exception("First element could not be Operator. " + filterElement);
        }

        FilterElement lastFilterElement = lastFilterElement();
        if (lastFilterElement != null) {
            if ((lastFilterElement instanceof Operator) && (filterElement instanceof Operator)) {
                throw new Exception("Filter element could not be Operator. " + filterElement);
            }

            if (!(lastFilterElement instanceof Operator) && !(filterElement instanceof Operator)) {
                throw new Exception("Filter element must be Operator. " + filterElement);
            }
        }

        filterElements.add(filterElement);
        return this;
    }

    String build(){
        StringBuilder stringBuilder=new StringBuilder();
        if (filterElements.isEmpty()){
            return stringBuilder.toString();
        }

        stringBuilder.append("WHERE");
        for(FilterElement filterElement:filterElements){
            if (filterElement instanceof Operator){
                stringBuilder.append(' ');
                stringBuilder.append(filterElement);
            }
            if (filterElement instanceof Filter){
                if (!stringBuilder.isEmpty()){
                    stringBuilder.append(' ');
                }
                stringBuilder.append(((Filter) filterElement).filterExpression());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "WhereBuilder{" +
                "filterElements=" + filterElements +
                '}';
    }

    private FilterElement lastFilterElement() {
        return filterElements.isEmpty() ? null : filterElements.get(filterElements.size() - 1);
    }
}
