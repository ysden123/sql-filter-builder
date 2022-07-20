package com.stulsoft.sql;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleFilterTest {

    @Test
    void filterExpression() {
        Filter filter = new SingleFilter("productName", CompareOperator.LIKE, "%stu%");
        assertEquals("productName LIKE '%stu%'", filter.filterExpression());
    }

    @Test
    void serializationTest(){
        Filter filter1 = new SingleFilter("productName", CompareOperator.LIKE, "%stu%");

        Gson gson = new Gson();
        String json = gson.toJson(filter1);

        Filter filter2 = gson.fromJson(json, Filter.class);

        assertEquals(filter1.toString(), filter2.toString());
    }
}