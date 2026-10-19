package userregistrationsystem;

import login.Message;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class messageTest {
    
    Message message;
    
    public messageTest() {
        
    }
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        message = new Message(1, "+27677428312", "Hi Mike, can you join us for dinner tonight?");
    }
    
    @After
    public void tearDown() {
        message = null;
    }
    
    @Test
    public void testCheckMessageID() {
        assertTrue("Message ID should be 10 characters or less", message.checkMessageID());
    }
    
    @Test
    public void testCheckRecipientCell() {
        String validNumber = message.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", validNumber);
        
        Message invalidMsg = new Message(2, "0677428312", "Test");
        String invalidNumber = invalidMsg.checkRecipientCell();
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", invalidNumber);
    }
    
    @Test
    public void testCreateMessageHash() {
        String hash = message.getMessageHash();
        String expectedEnd = ":1:HITONIGHT";
        assertTrue("Message hash should end with " + expectedEnd, hash.endsWith(expectedEnd));
        assertEquals(hash.toUpperCase(), hash);
    }
    
    @Test
    public void testSentMessage() {
        assertEquals("Message successfully sent.", message.sentMessage(1));
        assertEquals("Press 0 to delete the message.", message.sentMessage(2));
        assertEquals("Message successfully stored.", message.sentMessage(3));
    }
}
