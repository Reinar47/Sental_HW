package ru.sental.di;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertiesLoader {

    private PropertiesLoader() {
    }

    @SuppressWarnings("unchecked")
    public static Properties load(String resourceName) {

        Properties result = new Properties();

        try (InputStream inputStream = PropertiesLoader.class.getClassLoader()
                .getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IllegalStateException("Resource not found: " + resourceName);
            }
                Map<String, Object> yamlMap = new Yaml().load(inputStream);
                Map<String, Object> flatMap = new LinkedHashMap<>();
                flatten("", yamlMap, flatMap);
                flatMap.forEach((key, value) -> result.setProperty(key, String.valueOf(value)));

            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + resourceName, e);
        }
    }


    @SuppressWarnings("unchecked")
    private static void flatten(String prefix, Map<String, Object> source,
                                Map<String, Object> target) {
        for (Map.Entry<String, Object> entrySet : source.entrySet()) {
            String key = prefix.isEmpty() ? entrySet.getKey() : prefix + "." + entrySet.getKey();
            Object value = entrySet.getValue();
            if (value instanceof Map) {
                flatten(key, (Map<String, Object>) value, target);
            } else {
                target.put(key, value);
            }
        }
    }
}