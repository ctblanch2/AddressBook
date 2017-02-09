import app.model.AddressBook;
import app.model.BuddyInfo;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

/**
 * Created by cameronblanchard on 1/12/2017.
 */
public class AddressBookTest {

    @Test
    public void addBuddy() throws Exception {
        List<BuddyInfo> buddies;
        BuddyInfo bud1 = new BuddyInfo("peter", "1234567890");
        AddressBook book = new AddressBook();
        book.addBuddy(bud1);
        buddies = book.getBuddies();
        assertEquals(buddies.get(0), bud1);
    }

    @Test
    public void testToString() throws Exception {
        BuddyInfo bud1 = new BuddyInfo("peter", "1234567890");
        BuddyInfo bud2 = new BuddyInfo("jerp", "1234567890");
        AddressBook book = new AddressBook();
        book.addBuddy(bud1);
        book.addBuddy(bud2);
        assertEquals("Name: peter Number: 1234567890\nName: jerp Number: 1234567890\n", book.toString());
    }

    @Test
    public void testToStringEmpty() throws Exception {
        AddressBook book = new AddressBook();
        assertEquals("", book.toString());
    }

    @Test
    public void removeBuddy() throws Exception {
        AddressBook book = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("peter", "1234567890");
        book.addBuddy(bud1);
        assertEquals(1, book.getBuddies().size());
        book.removeBuddy(bud1);
        assertEquals(0, book.getBuddies().size());
    }
}