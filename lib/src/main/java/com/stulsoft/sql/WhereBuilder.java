package com.stulsoft.sql;

import java.util.Arrays;
import java.util.List;

public class WhereBuilder {

    public static String build(List<Filter> filters) {
        if (filters.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder(" WHERE ");
        // todo
/*
        for (int i = 0; i < filters.size(); ++i) {
            Filter filter = filters.get(i);
            if (i != 0) {
                stringBuilder.append(' ');
                stringBuilder.append(filter.getOperator());
                stringBuilder.append(' ');
            }

            stringBuilder.append(filter.filterExpression());
        }
*/

        return stringBuilder.toString();
    }

    public static String build(Filter[] filters) {
        return build(Arrays.asList(filters));
    }
}
