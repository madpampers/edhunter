package ru.edhunter.independent_seatwork.reflection.ru.edhunter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToXmlConverterTest {

    @Test
    public void test () throws IllegalAccessException {
        Person person = new Person(15, "Oleg");
        String xml = new ToXmlConverter().convert(person);
        assertEquals("<Person>\n" +
                "\t<age>15</age>\n" +
                "</Person>", xml);

    }
}
