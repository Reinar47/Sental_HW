package ru.sental.di;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;
import ru.sental.di.annotation.Value;
import ru.sental.di.utils.Converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class IocContainer {

    private static final Map<Class<?>, Object> BEANS = new LinkedHashMap<>();
    private static final Set<Class<?>> COMPONENTS = new LinkedHashSet<>();
    private static Properties properties;

    private IocContainer() {
    }

    public static void init(String basePackage, String propertiesResource) {

        properties = PropertiesLoader.load(propertiesResource);
        BEANS.clear();
        COMPONENTS.clear();

        try {
            Reflections reflections = new Reflections(basePackage, Scanners.TypesAnnotated);
            COMPONENTS.addAll(reflections.getTypesAnnotatedWith(Component.class));

            for (Class<?> clazz : COMPONENTS) {
                createBean(clazz);
            }

            injectDependencies();
        } catch (Exception e) {
            throw new RuntimeException("IoC initialization failed", e);
        }
    }

    /**
     * Создаёт бин и все его конструкторные зависимости (рекурсивно).
     * Возвращает готовый экземпляр — это значение используется
     * при создании зависимых бинов.
     */
    private static Object createBean(Class<?> clazz) throws Exception {

        Object existing = BEANS.get(clazz);
        if (existing != null) {
            return existing;
        }

        Constructor<?> autowiredConstructor = findAutowiredConstructor(clazz);
        Object instance;

        if (autowiredConstructor != null) {
            autowiredConstructor.setAccessible(true);
            Class<?>[] paramTypes = autowiredConstructor.getParameterTypes();

            Object[] args = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                args[i] = findOrCreateBean(paramTypes[i]);   // ← рекурсия
            }

            instance = autowiredConstructor.newInstance(args);
        } else {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = constructor.newInstance();
        }

        BEANS.put(clazz, instance);
        return instance;
    }

    /**
     * Возвращаем бин нужного типа; если он ещё не создан — создаём.
     * Ищем компонент, реализующий/наследующий type
     */
    private static Object findOrCreateBean(Class<?> type) throws Exception {
        Object existing = findExisting(type);
        if (existing != null) {
            return existing;
        }

        for (Class<?> candidate : COMPONENTS) {
            if (type.isAssignableFrom(candidate)) {
                return createBean(candidate);
            }
        }
        throw new IllegalStateException("No bean found for type: " + type.getName());
    }

    /**
     * Проверяем есть ли уже бин в мапе
     */
    private static Object findExisting(Class<?> type) {
        Object direct = BEANS.get(type);
        if (direct != null)

            return direct;
        for (Object bean : BEANS.values()) {
            if (type.isAssignableFrom(bean.getClass())) {

                return bean;
            }
        }
        return null;
    }


    /**
     * Достаём класс из мапы бинов и заполняем его поля
     */
    private static void injectDependencies() throws Exception {
        for (Object bean : BEANS.values()) {
            Class<?> clazz = bean.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Value.class)) {
                    field.setAccessible(true);
                    String key = field.getAnnotation(Value.class).value();
                    String raw = properties.getProperty(key);
                    if (raw == null) {
                        throw new IllegalStateException("Property not found: " + key);
                    }
                    field.set(bean, Converter.convert(raw, field.getType()));
                }
            }

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    field.set(bean, findExisting(field.getType()));
                }
            }

            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Autowired.class)
                        && method.getName().startsWith("set")
                        && method.getParameterCount() == 1) {
                    method.setAccessible(true);
                    method.invoke(bean, findExisting(method.getParameterTypes()[0]));
                }
            }
        }
    }

    /**
     * Запуск бина для демонстрации
     */
    public static <T> T getBean(Class<T> type) {
        Object bean = findExisting(type);
        if (bean == null) {
            throw new IllegalStateException("No bean found for type: " + type.getName());
        }
        return type.cast(bean);
    }

    /**
     * Проверяем есть ли в классе конструктор аннотированный @Autowired
     */
    private static Constructor<?> findAutowiredConstructor(Class<?> clazz) {
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            if (c.isAnnotationPresent(Autowired.class)) {
                return c;
            }
        }
        return null;
    }

//    private static Object convert(String raw, Class<?> type) {
//        String v = raw.trim();
//        if (type == String.class) return raw;
//        if (type == int.class || type == Integer.class) return Integer.parseInt(v);
//        if (type == long.class || type == Long.class) return Long.parseLong(v);
//        if (type == double.class || type == Double.class) return Double.parseDouble(v);
//        if (type == float.class || type == Float.class) return Float.parseFloat(v);
//        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(v);
//        if (type == short.class || type == Short.class) return Short.parseShort(v);
//        if (type == byte.class || type == Byte.class) return Byte.parseByte(v);
//        throw new IllegalArgumentException("Unsupported @Value target type: " + type);
//    }
}


//package ru.sental;
//
//
//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;
//import ru.sental.di.annotation.Autowired;
//import ru.sental.di.annotation.Component;
//import ru.sental.di.annotation.Value;
//import ru.sental.di.utils.Converter;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.LinkedHashMap;


//import java.util.Map;
//import java.util.Properties;
//import java.util.Set;
//
//public class IocContainer {
//
//    private static final Map<Class<?>, Object> BEANS = new LinkedHashMap<>();
//    private static Properties properties;
//
//    private IocContainer() {
//    }
//
//    public static void init(String basePackage, String propertiesResource) {
//
//        properties = PropertiesLoader.load(propertiesResource);
//        BEANS.clear();
//
//        try {
//            scanAndCreateBeans(basePackage);
//            injectDependencies();
//        } catch (Exception e) {
//            throw new RuntimeException("IoC initialization failed", e);
//        }
//    }
//
//    private static void scanAndCreateBeans(String basePackage) throws Exception {
//
//        Reflections reflections = new Reflections(basePackage, Scanners.TypesAnnotated);
//
//        Set<Class<?>> components = reflections.getTypesAnnotatedWith(Component.class);
//
//        for (Class<?> clazz : components) {
//            createBean(clazz);
//        }
//    }
//
//    /**
//     * Создаём бин
//     */
//    private static Object createBean(Class<?> clazz) throws Exception {
//
//        if (BEANS.containsKey(clazz)) {
//            return BEANS.get(clazz);
//        }
//
//        Constructor<?> autowiredConstructor = findAutowiredConstructor(clazz);
//
//        Object instance;
//
//        if (autowiredConstructor != null) {
//            autowiredConstructor.setAccessible(true);
//            Object[] args = resolveArgs(autowiredConstructor.getParameterTypes());
//            instance = autowiredConstructor.newInstance(args);
//        } else {
//            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
//            declaredConstructor.setAccessible(true);
//            instance = declaredConstructor.newInstance();
//        }
//        BEANS.put(clazz, instance);
//        return instance;
//    }
//
//
//    /**
//     * Достаём класс из мапы бинов и заполняем его поля
//     */
//    private static void injectDependencies() throws Exception {
//        for (Object bean : BEANS.values()) {
//            Class<?> clazz = bean.getClass();
//
//            // @Value в поля
//            for (Field field : clazz.getDeclaredFields()) {
//                if (field.isAnnotationPresent(Value.class)) {
//                    field.setAccessible(true);
//                    String key = field.getAnnotation(Value.class).value();
//                    String raw = properties.getProperty(key);
//                    if (raw == null) {
//                        throw new IllegalStateException("Property not found: " + key);
//                    }
//                    field.set(bean, Converter.convert(raw, field.getType()));
//                }
//            }
//
//            // @Autowired в поля
//            for (Field field : clazz.getDeclaredFields()) {
//                if (field.isAnnotationPresent(Autowired.class)) {
//                    field.setAccessible(true);
//                    field.set(bean, findBean(field.getType()));
//                }
//            }
//
//            // @Autowired в сеттеры
//            for (Method method : clazz.getDeclaredMethods()) {
//                if (method.isAnnotationPresent(Autowired.class)
//                        && method.getName().startsWith("set")
//                        && method.getParameterCount() == 1) {
//                    method.setAccessible(true);
//                    Object[] args = resolveArgs(method.getParameterTypes());
//                    method.invoke(bean, args);
//                }
//            }
//        }
//    }
//
//    /**
//     * Запуск бина для демонстрации
//     */
//    public static <T> T getBean(Class<T> type) {
//        Object bean = findBean(type);
//        return type.cast(bean);
//    }
//
//    /**
//     * Пытаемся найти бин в мапе бинов
//     */
//    private static Object findBean(Class<?> type) {
//        Object direct = BEANS.get(type);
//        if (direct != null) {
//
//            return direct;
//        }
//        for (Object bean : BEANS.values()) {
//            if (type.isAssignableFrom(bean.getClass())) {
//
//                return bean;
//            }
//        }
//        throw new IllegalStateException("No bean found for type: " + type.getName());
//    }
//
//    private static Object[] resolveArgs(Class<?>[] types) {
//        Object[] args = new Object[types.length];
//        for (int i = 0; i < types.length; i++) {
//            args[i] = findBean(types[i]);
//        }
//
//        return args;
//    }
//
//    /**
//     * Проверяем есть ли в классе конструктор аннотированный @Autowired
//     */
//    private static Constructor<?> findAutowiredConstructor(Class<?> clazz) {
//
//        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
//            if (constructor.isAnnotationPresent(Autowired.class)) {
//
//                return constructor;
//            }
//        }
//
//        return null;
//    }
//
/// /    private static Object convert(String raw, Class<?> type) {
/// /
/// /        String value = raw.trim();
/// /
/// /        if (type == String.class)
/// /
/// /            return raw;
/// /        if (type == int.class || type == Integer.class)
/// /
/// /            return Integer.parseInt(value);
/// /        if (type == long.class || type == Long.class)
/// /
/// /            return Long.parseLong(value);
/// /        if (type == double.class || type == Double.class)
/// /
/// /            return Double.parseDouble(value);
/// /        if (type == float.class || type == Float.class)
/// /
/// /            return Float.parseFloat(value);
/// /        if (type == boolean.class || type == Boolean.class)
/// /
/// /            return Boolean.parseBoolean(value);
/// /        if (type == short.class || type == Short.class)
/// /
/// /            return Short.parseShort(value);
/// /        if (type == byte.class || type == Byte.class)
/// /
/// /            return Byte.parseByte(value);
/// /
/// /        throw new IllegalArgumentException("Unsupported @Value target type: " + type);
/// /    }
//}