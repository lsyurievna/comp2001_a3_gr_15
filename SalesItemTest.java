
/** 
 * @author Liudmila Strelnikova
 * @version 08.03.2021
 */

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
    private SalesItem textbook;


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
        time.addComment("Bobby McGill", "Fake item but love the message", 2);
        time.addComment("NiceGuy", "I got two of these", 3);
        time.upvoteComment(1);
        time.upvoteComment(2);
        
        dollar = new SalesItem("One dollar", 1);
        dollar.addComment("Lucy Lu", "That's so cheap!", 5);
        
        textbook = new SalesItem("Any university textbook that you need", 500000);
        textbook.addComment("Poor Student", "I did not eat for three days but I got an A in JAVA thanks to this book", 5);
        textbook.addComment("Oxford Student", "Not helpful at all, read only the intro and got bored instantly", 1);
        textbook.addComment("Emma WhatSon", "Love books from this author, very good example projects but have to get a book with answers separately", 4);
        textbook.upvoteComment(0);
        textbook.upvoteComment(0);
        textbook.upvoteComment(1);
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
        assertEquals(3, textbook.getNumberOfComments());
        assertEquals(2, time.getNumberOfComments());
        assertEquals(0, mug.getNumberOfComments());
        assertEquals(1, dollar.getNumberOfComments());
    }

    @Test
    public void test_addComment()
    {
        assertEquals(true, dollar.addComment("iamnotabot", "Excellent stuff", 5));
        assertEquals(false, dollar.addComment("iamnotabot", "Perfect stuff", 5));
        assertEquals(false, mug.addComment("Jim Bob Joe", "Liked it too much", 6));
        assertEquals(false, mug.addComment("Bob Jim Joe", "Disliked it too much", 0));
    }

    

    @Test
    public void test_findMostHelpful()
    {
        assertEquals(textbook.getComment(0), textbook.findMostHelpfulComment());
        assertEquals(time.getComment(1), time.findMostHelpfulComment());
    }
    
    @Test
    public void test_removeComment()
    {
        textbook.removeComment(0); // romove first comment, check that it's deleted
        assertEquals("Not helpful at all, read only the intro and got bored instantly", textbook.getCommnetText(0));
        textbook.removeComment(1); //romove last comment, check that it and not the first one is deleted
        assertEquals("Not helpful at all, read only the intro and got bored instantly", textbook.getCommnetText(0));
        textbook.removeComment(5); //out of range, all comments should stay as they were
        assertEquals("Not helpful at all, read the into and got bored instantly", textbook.getCommnetText(0)); 
        mug.removeComment(0); //out of range (empty array), error message should appear
    }
    
    @Test
    public void testUpvote()
    {
        time.upvoteComment(0);
        assertEquals(1, time.getVotes(0));
        time.upvoteComment(0);
        assertEquals(2, time.getVotes(0));
        time.upvoteComment(-5);
        assertEquals(2, time.getVotes(0));
        assertEquals(1, time.getVotes(1));
        time.upvoteComment(5);
        assertEquals(2, time.getVotes(0));
        assertEquals(1, time.getVotes(1));
    }

    @Test
    public void test_downvote()
    {
        time.downvoteComment(2); //downvote to 0
        assertEquals(0, time.getVotes(2));
        textbook.downvoteComment(0); //downvote to 1
        assertEquals(1, textbook.getVotes(0)); 
    }

    @Test
    public void test_SalesItem()
    {
        SalesItem barracuda = new SalesItem("Barracuda", 65); // a normal posting
        SalesItem keyboard = new SalesItem("Gaming keyboard", -1); // a positng with negative price should be rejected
        assertEquals(0, keyboard.getPrice());
    }
}






