package com.dcj.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;



public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        SerializationConfig serializationConfig = mapper.getSerializationConfig().withDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.setSerializationConfig(serializationConfig);
    }
    public static <T> T readObject(String jsonStr,Class<T> T)
    {
        if(jsonStr==null||"".equals(jsonStr))
            return null;
        try {
            return mapper.readValue(jsonStr,T);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> readList(String jsonStr,TypeReference<List<T>> reference)
    {
        if(jsonStr==null||"".equals(jsonStr))
            return null;
        try {
            return mapper.readValue(jsonStr, reference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Map<String,String> readTree(String jsonStr)
    {
        if(jsonStr==null||"".equals(jsonStr))
            return null;
        Map<String,String> map = null;
        JsonNode root =  null;
        try {
            root = mapper.readTree(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(root!=null)
        {
            map = new HashMap<String,String>();
            for(Iterator<String> it=root.getFieldNames();it.hasNext();)
            {
                String field = it.next();
                map.put(field,root.get(field).getTextValue());
            }
        }
        return map;
    }
    public static void writeObj(OutputStream out,Object obj)
    {
        try {
            mapper.writeValue(out,obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String writeObjToString(Object obj)
    {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static byte[] writeObjToByte(Object obj)
    {
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

