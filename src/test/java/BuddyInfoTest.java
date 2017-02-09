import app.model.BuddyInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by cameronblanchard on 1/12/2017.
 */
public class BuddyInfoTest {

    BuddyInfo buddy;

    @Before
    public void setup() {
        buddy = new BuddyInfo("testname", "1234567890");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("testname", buddy.getName());
    }

    @Test
    public void setName() throws Exception {
        buddy.setName("myname");
        assertEquals("myname", buddy.getName());
    }

    @Test
    public void getNumber() throws Exception {
        assertEquals("1234567890", buddy.getNumber());
    }

    @Test
    public void setNumber() throws Exception {
        buddy.setNumber("0987654321");
        assertEquals("0987654321", buddy.getNumber());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Name: testname Number: 1234567890", buddy.toString());
    }
}