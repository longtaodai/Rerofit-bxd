package com.dltao.bxd.utill;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by leason on 2016/6/2.
 */
public class JsonHelper {
    public static Gson getGson(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Integer.class, new BadIntegerDeserializer())
                .registerTypeAdapter(Float.class, new BadFloatDeserializer())
                .registerTypeAdapter(Double.class, new BadDoubleDeserializer())
                .registerTypeHierarchyAdapter(Long.class, new BadLongDeserializer())
                .create();

        return gson;
    }

    private static class BadIntegerDeserializer implements
            JsonDeserializer<Integer> {

        @Override
        public Integer deserialize(JsonElement element, Type type,
                                   JsonDeserializationContext context) throws JsonParseException {
            try {
                if (element.getAsString().equals("")) {
                    return 0;
                }
                return Integer.parseInt(element.getAsString());
            } catch (NumberFormatException e) {
                throw new JsonParseException(e);
            }
        }

    }

    private static class BadFloatDeserializer implements
            JsonDeserializer<Float> {

        @Override
        public Float deserialize(JsonElement element, Type type,
                                 JsonDeserializationContext context) throws JsonParseException {
            try {
                if (element.getAsString().equals("")) {
                    return 0f;
                }
                return Float.parseFloat(element.getAsString());
            } catch (NumberFormatException e) {
                throw new JsonParseException(e);
            }
        }

    }

    private static class BadDoubleDeserializer implements
            JsonDeserializer<Double> {

        @Override
        public Double deserialize(JsonElement element, Type type,
                                  JsonDeserializationContext context) throws JsonParseException {
            try {
                if (element.getAsString().equals("")) {
                    return 0.0;
                }
                return Double.parseDouble(element.getAsString());
            } catch (NumberFormatException e) {
                throw new JsonParseException(e);
            }
        }

    }

    private static class BadLongDeserializer implements
            JsonDeserializer<Long> {

        @Override
        public Long deserialize(JsonElement element, Type type,
                                JsonDeserializationContext context) throws JsonParseException {
            try {
                if (element.getAsString().equals("")) {
                    return 0l;
                }
                return Long.parseLong(element.getAsString());
            } catch (NumberFormatException e) {
                throw new JsonParseException(e);
            }
        }

    }
}
