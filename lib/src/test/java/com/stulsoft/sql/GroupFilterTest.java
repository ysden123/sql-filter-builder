package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupFilterTest {

    @Test
    void filterExpressionEmpty() {
        FilterContainer filterContainer = new FilterContainer();
        GroupFilter groupFilter = new GroupFilter(filterContainer);
        assertTrue(groupFilter.filterExpression().isEmpty());
    }
    @Test
    void filterExpressionNotEmpty() throws Exception{
        FilterContainer filterContainer = new FilterContainer();
        filterContainer
                .addFilterElement(new SingleFilter("col1", CompareOperator.EQUAL, 1))
                .addFilterElement(Operator.AND)
                .addFilterElement(new SingleFilter("col2", CompareOperator.EQUAL, 2));
        GroupFilter groupFilter = new GroupFilter(filterContainer);
        String expression = groupFilter.filterExpression();
        assertFalse(expression.isEmpty());
        assertEquals("(col1 = 1 AND col2 = 2)", expression);
    }
}