package app.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cameronblanchard on 1/26/2017.
 */
public interface AddressBookRepository  extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findById(Long id);

}
