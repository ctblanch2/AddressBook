import app.model.AddressBook;
import app.model.BuddyInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cameronblanchard on 1/26/2017.
 */
public class AddBuddyActionListener implements ActionListener {

    private AddressBook book;
    private JTextField nameField;
    private JTextField numberField;

    public void actionPerformed(ActionEvent e) {
        book.addBuddy(new BuddyInfo(this.nameField.getText(), this.numberField.getText()));
    }

    public void setBook(AddressBook book){
        this.book = book;
    }

    public void setNumberField(JTextField numberField) {
        this.numberField = numberField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }
}
