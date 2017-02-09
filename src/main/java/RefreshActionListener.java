import app.model.AddressBook;
import app.model.BuddyInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cameronblanchard on 1/26/2017.
 */
public class RefreshActionListener implements ActionListener{

    private JList list;
    private AddressBook book;

    public void setList(JList list) {
        this.list = list;
    }

    public void setBook(AddressBook book) {
        this.book = book;
    }

    public void actionPerformed(ActionEvent e) {
        DefaultListModel listModel = new DefaultListModel();

        for (BuddyInfo i : this.book.getBuddies()){
            listModel.addElement(i.toString());
        }

        list.setModel(listModel);
    }
}
