package app.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

/**
 * Created by cameronblanchard on 1/12/2017.
 */
@Entity
@Component
public class AddressBook {

    private Long id;
    private List<BuddyInfo> buddies;
    private String name;

    public AddressBook() {
         this.buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        if (buddies.contains(buddy)){
            buddies.remove(buddy);
        }
    }

    @OneToMany
    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies){
        this.buddies = buddies;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        String bookString = "";
        for (BuddyInfo b : buddies) {
            bookString += b.toString() + "\n";
        }
        return bookString;
    }

    @Id
    @GeneratedValue
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }



    public static void main(String[] args){
        AddressBook book = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("Peter", "6123456657");
        BuddyInfo bud2 = new BuddyInfo("Jeremy", "6134567890");
        BuddyInfo bud3 = new BuddyInfo("Matt", "6131234567");
        book.addBuddy(bud1);
        book.addBuddy(bud2);
        book.addBuddy(bud2);

        System.out.println(book.toString());
    }
}
