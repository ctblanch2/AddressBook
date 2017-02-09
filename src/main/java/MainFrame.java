import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by cameronblanchard on 1/26/2017.
 */
public class MainFrame extends JFrame {

    private List<Component> components;
    private BuddyPanel buddyPanel;
    private AddressBookPanel addressBookPanel;

    public void init(){
        this.setSize(700,400);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (Component c : this.components){
            this.add(c);
            System.out.println("Adding a component");
        }
    }

    public void setComponents(List<Component> components){
        this.components = components;
    }

    public void setBuddyPanel(BuddyPanel buddyPanel) {
        this.buddyPanel = buddyPanel;
    }

    public void setAddressBookPanel(AddressBookPanel addressBookPanel) {
        this.addressBookPanel = addressBookPanel;
    }
}
