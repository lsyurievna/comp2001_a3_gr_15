

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesItemTest
{
    private SalesItem mug;
    private SalesItem time;
    private SalesItem dollar;
    private SalesItem texbook;


    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        mug = new SalesItem("Mug", -1);
        time = new SalesItem("The concept of time", 0);
        dollar = new SalesItem("One dollar", 1);
        texbook = new SalesItem("Any university textbook that you need", 500000);
        texbook.addComment("Poor Student", "I did not eat for three days but I got an A in JAVA thanks to this book", 5);
        texbook.addComment("Oxford Student", "Not helpful at all, read only the intro and got bored instantly", 1);
        texbook.addComment("Emma WhatSon", "Love books from this author, very good example projects but have to get a book with answers separately", 4);
        time.addComment("Bobby McGill", "Fake item but love the message", 2);
        time.addComment("NiceGuy", "I got two of these", 3);
        dollar.addComment("Lucy Lu", "That's so cheap!", 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    

    @Test
    public void test_getNumberOfComments()
    {
        assertEquals(3, texbook.getNumberOfComments());
        assertEquals(2, time.getNumberOfComments());
        assertEquals(0, mug.getNumberOfComments());
        assertEquals(1, dollar.getNumberOfComments());
    }
}


