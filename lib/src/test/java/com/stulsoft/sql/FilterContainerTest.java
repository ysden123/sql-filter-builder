package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterContainerTest {

    @Test
    void addFilterElement() {
        FilterContainer filterContainer = new FilterContainer();

        try {
            filterContainer
                    .addFilterElement(new SingleFilter("col1", CompareOperator.EQUAL, 1))
                    .addFilterElement(Operator.AND);
        } catch (Exception exception) {
            fail("Exception thrown: " + exception.getMessage(), exception);
        }
    }

    @Test
    void addFilterElementWrong1() {
        FilterContainer filterContainer = new FilterContainer();

        try {
            filterContainer.addFilterElement(Operator.AND)
                    .addFilterElement(new SingleFilter("col1", CompareOperator.EQUAL, 1));
            fail("An exception must be thrown");
        } catch (Exception ignore) {
        }
    }

    @Test
    void build1() {
        FilterContainer filterContainer = new FilterContainer();
        assertTrue(filterContainer.build().isEmpty());
    }

    @Test
    void build2() throws Exception {
        FilterContainer filterContainer = new FilterContainer();

        filterContainer
                .addFilterElement(new SingleFilter("col1", CompareOperator.EQUAL, 1))
                .addFilterElement(Operator.AND)
                .addFilterElement(new SingleFilter("col2", CompareOperator.EQUAL, 2));
        assertEquals("col1 = 1 AND col2 = 2", filterContainer.build());
    }
}