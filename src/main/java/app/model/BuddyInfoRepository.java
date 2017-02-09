package app.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by cameronblanchard on 1/26/2017.
 */
@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);
    void deleteByName(String name);
}
