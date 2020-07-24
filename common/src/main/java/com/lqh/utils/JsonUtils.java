package com.lqh.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lqh.exception.JSONException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * @author liqihua
 * @date 2020/6/22
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    public JsonUtils() {
    }

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            Class var0 = JsonUtils.class;
            synchronized(JsonUtils.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                }
            }
        }

        return objectMapper;
    }

    public static <T> T readValue(String json, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(json, typeReference);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(String json, Class<T> tClass) {
        try {
            return getObjectMapper().readValue(json, tClass);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(InputStream inputStream, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(inputStream, typeReference);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(InputStream inputStream, Class<T> tClass) {
        try {
            return getObjectMapper().readValue(inputStream, tClass);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(Reader reader, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(reader, typeReference);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(Reader reader, Class<T> tClass) {
        try {
            return getObjectMapper().readValue(reader, tClass);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(byte[] src, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(src, typeReference);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static <T> T readValue(byte[] src, Class<T> tClass) {
        try {
            return getObjectMapper().readValue(src, tClass);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static String writeValueAsString(Object value) {
        try {
            return getObjectMapper().writeValueAsString(value);
        } catch (Throwable var2) {
            throw new JSONException(var2.getMessage(), var2);
        }
    }

    public static void writeValue(OutputStream out, Object value) {
        try {
            getObjectMapper().writeValue(out, value);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }

    public static void writeValue(Writer w, Object value) {
        try {
            getObjectMapper().writeValue(w, value);
        } catch (Throwable var3) {
            throw new JSONException(var3.getMessage(), var3);
        }
    }
}
