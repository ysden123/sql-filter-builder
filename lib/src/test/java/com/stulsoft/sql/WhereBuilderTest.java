package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WhereBuilderTest {

    @Test
    void build1() {
        Filter[] filters = {
                new SingleFilter(Operator.AND, "prodName", CompareOperator.EQUAL, "test"),
                new SingleFilter(Operator.OR, "prodId", CompareOperator.EQUAL, 123)
        };

        assertEquals(" WHERE prodName = 'test' OR prodId = 123", WhereBuilder.build(filters));
    }

    @Test
    void build2() {
        Filter[] filters = {
                new SingleFilter(Operator.AND, "prodName", CompareOperator.EQUAL, "test"),
                new SingleFilter(Operator.OR, "prodId", CompareOperator.EQUAL, 123),
                new SingleFilter(Operator.AND, "index", CompareOperator.NOT_EQUAL, 9)
        };

        assertEquals(" WHERE prodName = 'test' OR prodId = 123 AND index != 9", WhereBuilder.build(filters));
    }

    @Test
    void build3() {
        Filter[] filters = {
                new SingleFilter(Operator.AND, "prodName", CompareOperator.EQUAL, "test"),
        };

        assertEquals(" WHERE prodName = 'test'", WhereBuilder.build(filters));
    }

    @Test
    void build4() {
        Filter[] singleFilters = {
                new SingleFilter(Operator.AND, "c1", CompareOperator.EQUAL, "test"),
                new SingleFilter(Operator.AND, "c2", CompareOperator.EQUAL, 2)
        };

        Filter[] filters = {
                new SingleFilter(Operator.AND, "nnn", CompareOperator.NOT_EQUAL, 5),
                new GroupFilter(Operator.OR, Arrays.asList(singleFilters))
        };
        assertEquals(" WHERE nnn != 5 OR (c1 = 'test' AND c2 = 2)", WhereBuilder.build(filters));
    }
}