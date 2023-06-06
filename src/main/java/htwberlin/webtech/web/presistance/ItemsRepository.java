package htwberlin.webtech.web.presistance;

import htwberlin.webtech.web.api.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends CrudRepository<Item, Long> {

}
