package ru.edhunter.independent_seatwork.reflection.ru.edhunter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void printAllFields(Class<?> clazz) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
    }

    public static void printAllMethods(Class<?> clazz) {
        while (clazz != null) {
            final Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod.getName());
            }
            clazz = clazz.getSuperclass();
        }
    }

    public static void invokeMethod(Object o) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class<?> clazz = o.getClass();

        for (Method method : clazz.getMethods()) {
            if (isGetter(method)) {
                Object result = method.invoke(o);
                System.out.println(result);
            }
        }
    }

    private static boolean isGetter(Method method) {
        return ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                && method.getParameterCount() == 0
                && method.getReturnType() != void.class);
    }
}
