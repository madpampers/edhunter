package ru.edhunter.independent_seatwork.reflection.from_session.ru.edhunter;

import java.lang.reflect.Field;

public class ToXmlConverter implements ToStringConverter {
    @Override
    public String convert(Object o) throws IllegalAccessException {
        final Class<?> clazz = o.getClass();

        StringBuilder builder = new StringBuilder();

        builder.append("<").append(clazz.getSimpleName()).append(">");

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            final Ignore annotation = field.getAnnotation(Ignore.class);
            final String prefix = annotation.prefix();
            final int greater = annotation.greater();
            Object value = field.get(o);

            if (!prefix.equals("")) {
                if (value != null && value.toString().startsWith(prefix)) continue;
            } else if (field.getType() == int.class) {
                if ((Integer) value > 50 || greater == -1) continue;
            } else continue;
            builder.append("\n")
                    .append("\t<")
                    .append(field.getName())
                    .append(">").append(field.get(o))
                    .append("</").append(field.getName())
                    .append(">");
        }

        builder.append("\n</")
                .append(clazz.getSimpleName())
                .append(">");


        return builder.toString();
    }
}
