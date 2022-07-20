package com.stulsoft.sql;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yuriy Stul
 **/
public class ConvertToJsonTest {
    @Test
    void test1() throws Exception{
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

        Gson gson = new Gson();
        String json = gson.toJson(whereBuilder);
        System.out.println(json);
        WhereBuilder whereBuilderFromJson = gson.fromJson(json, WhereBuilder.class);
        assertEquals("WHERE c1 = 1 AND c2 = 2 AND (c3 = 3 OR c3 = 33)",
                whereBuilderFromJson.build());
    }
}
