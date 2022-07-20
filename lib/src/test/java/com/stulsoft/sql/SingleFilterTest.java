package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleFilterTest {

    @Test
    void filterExpression() {
        Filter filter = new SingleFilter("productName", CompareOperator.LIKE, "%stu%");
        assertEquals("productName LIKE '%stu%'", filter.filterExpression());
    }
}