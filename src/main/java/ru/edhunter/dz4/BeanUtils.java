package ru.edhunter.dz4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * The method takes care only about public methods.
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     *
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        final Method[] methods = from.getClass().getMethods();

        for (Method method : methods) {
            if (isGetter(method)) {
                final Method correspondentSetter = findCorrespondentSetter(to, method.getReturnType());
                if (correspondentSetter != null) {
                    invokeSetter(correspondentSetter, to, method.invoke(from));
                }
            }
        }

    }

    /**
     * invokes Setter from 'to' object
     *
     * @param to                      Object which properties will be set
     * @param correspondentSetter     Setter, that was chosen with findCorrespondentSetter(...) method
     * @param returnValueOfFromGetter Object, returned by Object which properties will be used to get values
     */
    private static void invokeSetter(Method correspondentSetter, Object to, Object returnValueOfFromGetter)
            throws InvocationTargetException, IllegalAccessException {

        correspondentSetter.invoke(to, returnValueOfFromGetter);

    }

    /**
     * method finds correct Setter, which is suitable for some return value of getter
     *
     * @param to         Object which properties will be set
     * @param returnType type of return value of getter
     * @return returns setter that corresponds  getter, null otherwise
     */
    private static Method findCorrespondentSetter(Object to, Class<?> returnType) {
        final Method[] methods = to.getClass().getMethods();

        for (Method method : methods) {
            if (isSetter(method)) {
                if (getSetterParameterType(method).isAssignableFrom(returnType)) {
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * checking method for being setter
     *
     * @param method method that checks
     * @return returns true, if method setter, false otherwise
     */
    private static boolean isSetter(Method method) {
        return (method.getName().startsWith("set")
                && method.getParameterCount() == 1);
    }

    /**
     * checking method for being getter
     *
     * @param method method that checks
     * @return returns true, if method getter, false otherwise
     */
    private static boolean isGetter(Method method) {
        return ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                && method.getParameterCount() == 0
                && method.getReturnType() != void.class);
    }

    /**
     * getting type of setter parameter
     *
     * @param setter setter, which parameter type we need to check
     * @return returns type of setter parameter
     */
    private static Class<?> getSetterParameterType(Method setter) {
        final Class<?>[] parameterTypes = setter.getParameterTypes();
        return parameterTypes[0];
    }
}
