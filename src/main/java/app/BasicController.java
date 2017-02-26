package app;

import app.model.AddressBook;
import app.model.AddressBookRepository;
import app.model.BuddyInfo;
import app.model.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Created by cameronblanchard on 2/16/2017.
 */
@Controller
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    AddressBook book;

    @Autowired
    AddressBookRepository repo;

    @Autowired
    BuddyInfoRepository buddyRepo;

    @RequestMapping("/addBuddy")
    public String listAddressBooks(@RequestParam(value="id") Long id,
                                   @ModelAttribute("buddy") BuddyInfo bud,
                                   Model model){
        book = repo.findById(id).get(0);
        book.addBuddy(bud);
        buddyRepo.save(bud);
        repo.save(book);
        model.addAttribute("buddy", bud);
        model.addAttribute("addressBookId", book.getId());
        return "showBuddy";
    }

    @RequestMapping("/showAddressBook")
    public String listAddressBooks(@RequestParam(value="id") Long id, Model model){
        book = repo.findById(id).get(0);
        model.addAttribute("addressBookId", book.getId());
        model.addAttribute("buddyList", book.getBuddies());
        return "showAddressBook";
    }

    @RequestMapping("/createBook")
    public String createAddressBook(Model model) {
        AddressBook book = new AddressBook();
        repo.save(book);
        model.addAttribute("addressBookId", book.getId());
        model.addAttribute("buddy", new BuddyInfo());
        return "addressBook";
    }

    @RequestMapping("/createBuddy")
    public String createBuddy(@RequestParam(value="id") Long id, Model model) {
        model.addAttribute("addressBookId", id);
        model.addAttribute("buddy", new BuddyInfo());
        return "addressBook";
    }

    @RequestMapping("/")
    public String landingPage(Model model){
        model.addAttribute("addressBook", new AddressBook());
        return "landing";
    }
}
