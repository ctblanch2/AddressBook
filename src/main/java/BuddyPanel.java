import app.model.AddressBook;
import app.model.BuddyInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by cameronblanchard on 1/26/2017.
 */
public class BuddyPanel extends JPanel implements ActionListener{

    private JButton addButton;
    private JTextField nameField;
    private JTextField numberField;
    private JLabel nameLabel;
    private JLabel numberLabel;
    private AddressBook book;

    public void init() {
        this.setLayout(new FlowLayout());
        this.addButton = new JButton("Add");
        this.nameField = new JTextField(20);
        this.numberField = new JTextField(20);
        this.nameLabel = new JLabel("Name: ");
        this.numberLabel = new JLabel("Number: ");
        this.add(nameLabel);
        this.add(nameField);
        this.add(numberLabel);
        this.add(numberField);
        this.add(addButton);
        AddBuddyActionListener listener = new AddBuddyActionListener();
        listener.setBook(book);
        listener.setNameField(nameField);
        listener.setNumberField(numberField);
        addButton.addActionListener(listener);
    }

    public void setBook(AddressBook book){
        this.book = book;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addButton)){
            book.addBuddy(new BuddyInfo(this.nameField.getText(), this.numberField.getText()));
        }
    }
}
