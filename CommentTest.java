/**
 * @author Liudmila Strelnikova
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    
    private Comment comment1;
    private Comment comment3;
    private Comment comment5;
    

    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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
        
        comment1 = new Comment("Lila Doomsday", "Not recommending this to anyone", 1);
        
        comment3 = new Comment("user2021", "Kinda bad but I like the color", 3);
        comment3.upvote();
        
        comment5 = new Comment("Jenna Williams", "Best gift for your ex", 5);
        comment5.upvote();
        comment5.upvote();
        
        
       
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
    public void test_getRating()
    {
        
        assertEquals(1, comment1.getRating());
        assertEquals(3, comment3.getRating());
        assertEquals(5, comment5.getRating());
        
    }

    @Test
    public void test_downVote()
    {
       
        comment1.downvote();
        assertEquals(0, comment1.getVoteCount()); // 0 is the minimum
        comment3.downvote();
        assertEquals(1, comment3.getVoteCount());
        comment5.downvote();
        assertEquals(2, comment5.getVoteCount());
       
    }
}


