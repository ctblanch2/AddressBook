import app.model.AddressBook;

import java.awt.*;

/**
 * Created by cameronblanchard on 1/26/2017.
 */
public class App {

    public static void main(String[] args){
        MainFrame fr = new MainFrame();
        AddressBook book = new AddressBook();
        BuddyPanel addPanel = new BuddyPanel();
        AddressBookPanel listPanel = new AddressBookPanel();
        fr.add(addPanel, BorderLayout.NORTH);
        fr.add(listPanel, BorderLayout.CENTER);
        fr.setVisible(true);
    }
}
