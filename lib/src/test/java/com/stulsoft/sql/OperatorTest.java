package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    public void valueTest() {
        assertEquals("AND", Operator.AND.toString());
        assertEquals("AND", Operator.AND.name());

        assertEquals("OR", Operator.OR.toString());
        assertEquals("OR", Operator.OR.name());
    }

}