package ru.edhunter.independent_seatwork.reflection.ru.edhunter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Ignore {
    String prefix() default "";
    int greater() default -1;
}
