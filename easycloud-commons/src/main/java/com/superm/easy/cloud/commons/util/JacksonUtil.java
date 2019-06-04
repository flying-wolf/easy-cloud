package com.superm.easy.cloud.commons.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superm.easy.cloud.commons.exception.UnSerializableException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/** 
 * @author hu.sheng
 * @since 20190425
 */
public final class JacksonUtil {
    private static ObjectMapper objectMapper;

    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        try {
            return getObjectMapper().readValue(jsonStr, valueType);
        } catch (IOException e) {
            throw new UnSerializableException("convert json:" + jsonStr + " to " + valueType.getName() + " error!", e);
        }
    }

    public static <T> T readValue(File file, Class<T> valueType) {
        try {
            return getObjectMapper().readValue(file, valueType);
        } catch (IOException e) {
            throw new UnSerializableException("convert file to " + valueType.getName() + " error!", e);
        }
    }

    public static <T> T readValue(InputStream io, Class<T> valueType) {
        try {
            return getObjectMapper().readValue(io, valueType);
        } catch (IOException e) {
            throw new UnSerializableException("convert inputstream to " + valueType.getName() + " error!", e);
        }
    }

    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef) {
        try {
            return getObjectMapper().readValue(jsonStr, valueTypeRef);
        } catch (IOException e) {
            throw new UnSerializableException(
                "convert json:" + jsonStr + " to " + valueTypeRef.getType().getTypeName() + " error!", e);
        }
    }

    public static String toJsonStr(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (IOException e) {
            throw new UnSerializableException("convert bean:" + object.getClass().getName() + " to json string error!",
                e);
        }
    }

    public static JSONObject toJson(Object object) {
        try {
            JSONObject json = new JSONObject(toJsonStr(object));
            return json;
        } catch (JSONException e) {
            throw new UnSerializableException("convert bean:" + object.getClass().getName() + " to json error!", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonStrToMap(String str) {
        try {
            return getObjectMapper().readValue(str, HashMap.class);
        } catch (IOException e) {
            throw new UnSerializableException("transe json str:" + str + " to map error!", e);
        }
    }

    public static Map<String, Object> extractProperties(Object obj, String... properties) {
        Map<String, Object> rsMap = new HashMap<>();
        if (properties.length > 0) {
            Map<String, Object> map = objToMap(obj);
            for (String prop : properties) {
                rsMap.put(prop, map.getOrDefault(prop, ""));
            }
        }
        return rsMap;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> objToMap(Object obj) {
        return getObjectMapper().convertValue(obj, HashMap.class);
    }

    public static String mapToJsonStr(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject json = new JSONObject(map);
        return json.toString();
    }

    public static JSONObject mapToJson(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JSONObject(map);
    }

    private static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    public static void main(String[] args) throws JSONException {
        Map<String, Object> m = new HashMap<>();
        Map<String, Object> nM = new HashMap<>();
        String[] strs = {"a", "b", "c"};
        for (String str : strs) {
            nM.put(str, m.get(str));
        }
        System.out.println(nM.size());
    }

}
