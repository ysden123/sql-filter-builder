package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GroupFilterTest {

    @Test
    void filterExpression() {
        Filter f1 = new SingleFilter(Operator.AND, "col1", CompareOperator.EQUAL, "abc");
        Filter f2 = new SingleFilter(Operator.AND, "col2", CompareOperator.EQUAL, "ddd");
        Filter f3 = new SingleFilter(Operator.AND, "col3", CompareOperator.EQUAL, "hhh");

        GroupFilter groupFilter = new GroupFilter(Operator.AND, Arrays.asList(f1, f2, f3));

        assertEquals("(col1 = 'abc' AND col2 = 'ddd' AND col3 = 'hhh')", groupFilter.filterExpression());
    }
}