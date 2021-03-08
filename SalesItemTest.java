import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * This a testing class for class SalesItem. It contains methods
 * that verify correctness of all SalesItem public methods
 * (methods getName, getPrice, showInfo and SalesItem are ignored)
 * @author Liudmila Strelnikova
 * @version 08.03.2021
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
        time.upvoteComment(0);
        time.upvoteComment(1);
        
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
    public void test_removeComment()
    {
        textbook.removeComment(0);
        assertEquals("Not helpful at all, read only the intro and got bored instantly", textbook.getCommentText(0));
        textbook.removeComment(1); 
        assertEquals("Not helpful at all, read only the intro and got bored instantly", textbook.getCommentText(0));
        textbook.removeComment(5);
        assertEquals("Not helpful at all, read only the intro and got bored instantly", textbook.getCommentText(0)); 
        textbook.removeComment(-1);
        assertEquals("Not helpful at all, read only the intro and got bored instantly", textbook.getCommentText(0));
    }
    
    
    @Test
    public void test_upvoteComment()
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
    public void test_downvoteComment()
    {
        time.downvoteComment(1); 
        assertEquals(0, time.getVotes(1));
        textbook.downvoteComment(0); 
        assertEquals(0, textbook.getVotes(0)); 
        time.downvoteComment(-5);
        assertEquals(0, time.getVotes(0));
        assertEquals(0, time.getVotes(1));
        time.downvoteComment(5);
        assertEquals(0, time.getVotes(0));
        assertEquals(0, time.getVotes(1));
    }

}






