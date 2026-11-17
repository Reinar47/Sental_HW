package ru.sental.di.utils;

public class Converter {

    public static Object convert(String raw, Class<?> type) {

        String value = raw.trim();

        if (type == String.class)

            return raw;
        if (type == int.class || type == Integer.class)

            return Integer.parseInt(value);
        if (type == long.class || type == Long.class)

            return Long.parseLong(value);
        if (type == double.class || type == Double.class)

            return Double.parseDouble(value);
        if (type == float.class || type == Float.class)

            return Float.parseFloat(value);
        if (type == boolean.class || type == Boolean.class)

            return Boolean.parseBoolean(value);
        if (type == short.class || type == Short.class)

            return Short.parseShort(value);
        if (type == byte.class || type == Byte.class)

            return Byte.parseByte(value);

        throw new IllegalArgumentException("Unsupported @Value target type: " + type);
    }
}
