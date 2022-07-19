package com.stulsoft.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class WhereBuilderTest {

    @Test
    void addFilterElement() throws Exception {
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder
                .addFilterElement(new SingleFilter("c1", CompareOperator.EQUAL, 1))
                .addFilterElement(Operator.AND)
                .addFilterElement(new SingleFilter("c2", CompareOperator.EQUAL, 2))
                .addFilterElement(Operator.AND)
                .addFilterElement(new GroupFilter(new FilterContainer()
                                .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 3))
                                .addFilterElement(Operator.OR)
                                .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 33))
                        )
                );
        assertEquals("WhereBuilder{filterElements=[SingleFilter{columnName='c1', compareOperator==, value=1}, AND, SingleFilter{columnName='c2', compareOperator==, value=2}, AND, GroupFilter{filterContainer=FilterContainer{filterElements=[SingleFilter{columnName='c3', compareOperator==, value=3}, OR, SingleFilter{columnName='c3', compareOperator==, value=33}]}}]}",
                whereBuilder.toString());
    }

    @Test
    void addFilterElementWrong1() {
        try {
            WhereBuilder whereBuilder = new WhereBuilder();

            whereBuilder
                    .addFilterElement(new SingleFilter("c1", CompareOperator.EQUAL, 1))
                    .addFilterElement(new SingleFilter("c2", CompareOperator.EQUAL, 2))
                    .addFilterElement(Operator.AND)
                    .addFilterElement(new GroupFilter(new FilterContainer()
                                    .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 3))
                                    .addFilterElement(Operator.OR)
                                    .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 33))
                            )
                    );
            fail("An exception must be thrown");
        } catch (Exception ignore) {
        }
    }

    @Test
    void addFilterElementWrong2() {
        try {
            WhereBuilder whereBuilder = new WhereBuilder();
            whereBuilder
                    .addFilterElement(new SingleFilter("c1", CompareOperator.EQUAL, 1))
                    .addFilterElement(Operator.AND)
                    .addFilterElement(new SingleFilter("c2", CompareOperator.EQUAL, 2))
                    .addFilterElement(new GroupFilter(new FilterContainer()
                                    .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 3))
                                    .addFilterElement(Operator.OR)
                                    .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 33))
                            )
                    );
            fail("An exception must be thrown");
        } catch (Exception ignore) {
        }
    }

    @Test
    void build1() throws Exception {
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder
                .addFilterElement(new SingleFilter("c1", CompareOperator.EQUAL, 1))
                .addFilterElement(Operator.AND)
                .addFilterElement(new SingleFilter("c2", CompareOperator.EQUAL, 2))
                .addFilterElement(Operator.AND)
                .addFilterElement(new GroupFilter(new FilterContainer()
                                .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 3))
                                .addFilterElement(Operator.OR)
                                .addFilterElement(new SingleFilter("c3", CompareOperator.EQUAL, 33))
                        )
                );

        assertEquals("WHERE c1 = 1 AND c2 = 2 AND (c3 = 3 OR c3 = 33)",
                whereBuilder.build());
    }

    @Test
    void build2() throws Exception {
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder
                .addFilterElement(new SingleFilter("prodName", CompareOperator.EQUAL, "test"))
                .addFilterElement(Operator.OR)
                .addFilterElement(new SingleFilter("prodId", CompareOperator.EQUAL, 123))
                .addFilterElement(Operator.AND)
                .addFilterElement(new SingleFilter("index", CompareOperator.NOT_EQUAL, 9));
        assertEquals("WHERE prodName = 'test' OR prodId = 123 AND index != 9", whereBuilder.build());
    }

    @Test
    void build3() throws Exception {
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder
                .addFilterElement(new SingleFilter("prodName", CompareOperator.EQUAL, "test"));
        assertEquals("WHERE prodName = 'test'", whereBuilder.build());
    }

    @Test
    void build4() throws Exception {
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder
                .addFilterElement(new SingleFilter("c1", CompareOperator.EQUAL, "test"))
                .addFilterElement(Operator.OR)
                .addFilterElement(new SingleFilter("c2", CompareOperator.EQUAL, 2));
        assertEquals("WHERE c1 = 'test' OR c2 = 2", whereBuilder.build());
    }
}