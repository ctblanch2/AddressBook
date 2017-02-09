package app.model; /**
 * Created by cameronblanchard on 1/12/2017.
 */
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    private String name;
    private String number;

    public BuddyInfo(){

    }

    public BuddyInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Number: " + this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuddyInfo buddyInfo = (BuddyInfo) o;

        if (name != null ? !name.equals(buddyInfo.name) : buddyInfo.name != null) return false;
        return number != null ? number.equals(buddyInfo.number) : buddyInfo.number == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
