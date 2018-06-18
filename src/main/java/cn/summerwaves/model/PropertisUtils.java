package cn.summerwaves.model;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertisUtils {
    public static Map getProperties(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream("src\\main\\resources\\PATH".replace("PATH",path)),"gbk"));
        Enumeration enumeration = properties.propertyNames();
        Map<String, String> propertiesMap = new HashMap<String, String>();

        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }
        return propertiesMap;
    }
}
