package ru.edhunter.dz2;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testMarry () {
        Person vlad = new Person(true,"Vlad");
        Person andrey = new Person(true, "Andrey");
        Person mary = new Person(false, "Mary");
        Person kate = new Person(false, "Kate");

        Assert.assertFalse(vlad.marry(andrey));
        Assert.assertTrue(mary.marry(vlad));
        vlad.marry(kate);
        Assert.assertNull(mary.getSpouse());
        Assert.assertFalse(vlad.marry(kate));
        Assert.assertFalse(andrey.marry(andrey));
    }

    @Test
    public void testDivorce () {
        Person vlad = new Person(true,"Vlad");
        Person andrey = new Person(true, "Andrey");
        Person mary = new Person(false, "Mary");
        Person kate = new Person(false, "Kate");

        Assert.assertFalse(vlad.divorce());
        vlad.marry(mary);
        Assert.assertTrue(vlad.divorce());
        Assert.assertNull(mary.getSpouse());
        Assert.assertNull(vlad.getSpouse());
        andrey.marry(kate);
        Assert.assertTrue(andrey.divorce());
        Assert.assertFalse(kate.divorce());
    }
}
