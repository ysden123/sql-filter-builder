package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareOperatorTest {

    @Test
    void testToString() {
        assertEquals("LIKE", CompareOperator.LIKE.name());
        assertEquals("LIKE", CompareOperator.LIKE.toString());

        assertEquals("EQUAL", CompareOperator.EQUAL.name());
        assertEquals("=", CompareOperator.EQUAL.toString());
        assertEquals("=", CompareOperator.EQUAL.value);

        assertEquals("NOT_EQUAL", CompareOperator.NOT_EQUAL.name());
        assertEquals("!=", CompareOperator.NOT_EQUAL.toString());
        assertEquals("!=", CompareOperator.NOT_EQUAL.value);
    }
}