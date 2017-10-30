package ru.edhunter.dz4;

import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;

public class BeanUtilsTest {
    private static Person personA;
    private static Person personB;
    private static PersonWithIncorrectSetter personC;
    private static Pet pet;
    private static Cat cat;

    @Before
    public void prepareTest1() {
        personA = new Person("Vova", 15);
        personB = new Person("Dima", 20);
    }

    @Test
    public void testSameTypes() throws InvocationTargetException, IllegalAccessException {
        Person fromPerson = new Person(personA.getName(), personA.getAge());
        BeanUtils.assign(personB, personA);
        assertEquals(personA.getName(), personB.getName());
        assertEquals(personA.getAge(), personB.getAge());
        assertEquals(fromPerson.getName(), personB.getName());
        assertEquals(fromPerson.getAge(), personB.getAge());
    }

    @Before
    public void prepareTest2() {
        personA = new Person("Vova", 15);
        personB = new Person("Dima", 20);
        personA.setPet(new Cat());
}

    @Test
    public void testSuperClassSetterType() throws InvocationTargetException, IllegalAccessException {
        BeanUtils.assign(personB, personA);
        assertEquals(personA.getPet(), personA.getPet());
    }

    @Before
    public void prepareTest3() throws InvocationTargetException, IllegalAccessException {
        personA = new Person("Vova", 15);
        pet = new Cat();
        pet.setName("murka");
        pet.setAge(2);
    }

    @Test
    public void testDifferentClassesCorrectSetterAndGetter() throws InvocationTargetException, IllegalAccessException {
        BeanUtils.assign(personA, pet);

        assertEquals(pet.getName(), personA.getName());
        assertEquals(pet.getAge(), personA.getAge());
    }

    @Before
    public void prepareTest4() throws InvocationTargetException, IllegalAccessException {
        personA = new Person("Vova", 15);
        personC = new PersonWithIncorrectSetter("Vasia", 20);
    }

    @Test
    public void testDifferentClassesBadSetterGoodGetter() throws InvocationTargetException, IllegalAccessException {
        BeanUtils.assign(personC, personA);
        assertNotEquals(personA.getName(), personC.getName());

        BeanUtils.assign(personA, personC);
        assertEquals(personA.getName(), personC.getName());
    }

    @Before
    public void prepareTest5 () {
        cat = new Cat();
        pet = new Pet();
        pet.setName("murka");
        pet.setAge(3);
    }

    @Test
    public void testInvokeSettersandGettersOfSuperClass() throws InvocationTargetException, IllegalAccessException {
        BeanUtils.assign(cat, pet);
        assertEquals(pet.getName(), cat.getName());
        assertEquals(pet.getAge(), pet.getAge());
        cat = new Cat();
        BeanUtils.assign(pet,cat);
        assertEquals(pet.getName(), cat.getName());
        assertEquals(pet.getAge(), pet.getAge());
    }

    @Test
    public void testSomeThing () throws InvocationTargetException, IllegalAccessException {
        Tester tester = new Tester();
        personA = new Person("Petya", 26);

        BeanUtils.assign(personA, tester);
        assertEquals(26, personA.getAge());
        assertEquals("Petya", personA.getName());

        BeanUtils.assign(tester, personA);

    }
}
