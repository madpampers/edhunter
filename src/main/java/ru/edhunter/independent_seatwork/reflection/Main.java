package ru.edhunter.independent_seatwork.reflection;

import ru.edhunter.independent_seatwork.reflection.ru.edhunter.Person;
import ru.edhunter.independent_seatwork.reflection.ru.edhunter.ReflectionUtils;
import ru.edhunter.independent_seatwork.reflection.ru.edhunter.ToXmlConverter;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
//        ReflectionUtils.printAllFields(String.class);
//        System.out.println("");
//        ReflectionUtils.printAllFields(Integer.class);
//        ReflectionUtils.printAllMethods(String.class);
//        ReflectionUtils.printAllMethods(Integer.class);
//        final String oleg = new ToXmlConverter().convert(new Person(15, "Oleg"));
//        System.out.println(oleg);
        Person person = new Person(15, "PPaleg");
        System.out.println(new ToXmlConverter().convert(person));
    }
}
