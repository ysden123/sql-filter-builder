package com.stulsoft.sql.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Parser {
    public static String parse(String jsonString){
        if (jsonString == null || jsonString.isEmpty()){
            return "";
        }
        Gson gson=new Gson();
        JsonElement json = gson.fromJson(jsonString, JsonElement.class);

        if (json.isJsonObject()){
            String fieldName = json.getAsJsonObject().getAsJsonPrimitive("fieldName").getAsString();
            String compareOperatorName = json.getAsJsonObject().getAsJsonPrimitive("compareOperator").getAsString();
            JsonPrimitive jsonPrimitive = json.getAsJsonObject().getAsJsonPrimitive("value");
            System.out.println(jsonPrimitive);
            jsonPrimitive.
        }
        return "";
    }
}
