package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class Dog {

    String name = "Doggi";

    String getDoggieName(){
        String temp = Integer.toString(1);
        return name;
    }

}

/**
 * Unit test for simple App.
 */
//todo
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    @Contract(" -> new")
    public static @NotNull Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        Dog myDog = new Dog();
        String myDogName = myDog.getDoggieName();

        int length = "Hello world".length();
        assertTrue( true );
    }

}
