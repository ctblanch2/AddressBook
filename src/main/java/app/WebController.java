package app;

import app.model.AddressBook;
import app.model.AddressBookRepository;
import app.model.BuddyInfo;
import app.model.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("fancy")
public class WebController {

    @Autowired
    AddressBook book;

    @Autowired
    AddressBookRepository repo;

    @Autowired
    BuddyInfoRepository buddyRepo;

    @RequestMapping("/createAddressBook")
    public Long createAddressBook(){
        AddressBook book = new AddressBook();
        repo.save(book);
        return book.getId();
    }

    @RequestMapping(value="/addBuddy", method=GET)
    public BuddyInfo addBuddyInfo(@RequestParam(value="id") Long id, @RequestParam(value="name") String name, @RequestParam(value="number") String number, @RequestParam(value="address") String address) {
        BuddyInfo buddy = new BuddyInfo(name, number, address);
        AddressBook book = repo.findById(id).get(0);
        book.addBuddy(buddy);
        buddyRepo.save(buddy);
        repo.save(book);
        return buddy;
    }

    @RequestMapping(value="removeBuddy")
    public String removeBuddyInfo(@RequestParam(value="id") Long id, @RequestParam(value="name") String name){
        BuddyInfo info = buddyRepo.findByName(name).get(0);
        AddressBook book = repo.findById(id).get(0);
        book.removeBuddy(info);
        repo.save(book);
        return "Success";
    }

    @RequestMapping("/getBuddies")
    public List<BuddyInfo> getBuddies(@RequestParam(value="id") Long id) {
        List<AddressBook> books = repo.findById(id);
        return books.get(0).getBuddies();
    }



}
