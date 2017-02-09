import app.model.AddressBook;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cameronblanchard on 1/26/2017.
 */

public class AddressBookPanel extends JPanel{

    private JList list;
    private AddressBook book;
    private JButton refresh;

    public void init() {
        DefaultListModel listModel = new DefaultListModel();

        list = new JList(listModel);

        refresh = new JButton("Refresh");

        RefreshActionListener listener = new RefreshActionListener();
        listener.setBook(this.book);
        listener.setList(list);
        refresh.addActionListener(listener);

        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        this.add(list, BorderLayout.CENTER);
        this.add(refresh, BorderLayout.SOUTH);
    }

    public void setBook(AddressBook book){
        this.book = book;
    }
}
