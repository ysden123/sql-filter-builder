package com.stulsoft.sql;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    class Container {
        private Operator operator;

        protected Container(Operator operator) {
            this.operator = operator;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "operator=" + operator +
                    '}';
        }
    }

    @Test
    public void valueTest() {
        assertEquals("AND", Operator.AND.toString());
        assertEquals("AND", Operator.AND.name());

        assertEquals("OR", Operator.OR.toString());
        assertEquals("OR", Operator.OR.name());
    }

    @Test
    void serializationTest() {
        Container container1 = new Container(Operator.AND);
        Gson gson = new Gson();
        String json = gson.toJson(container1);

        Container container2 = gson.fromJson(json, Container.class);

        assertEquals(container1.toString(), container2.toString());
    }

}