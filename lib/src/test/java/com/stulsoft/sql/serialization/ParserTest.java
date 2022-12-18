package com.stulsoft.sql.serialization;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class ParserTest {

    @Test
    void parse() throws Exception {
        InputStream inputStream = ParserTest.class.getClassLoader().getResourceAsStream("example1.json");
        assert (inputStream != null);
        String jsonString = new String(inputStream.readAllBytes());
        inputStream.close();
        System.out.println(jsonString);
        System.out.println(Parser.parse(jsonString));
    }
}