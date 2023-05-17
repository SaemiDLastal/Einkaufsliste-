package htwberlin.webtech.web.presistance;

import htwberlin.webtech.web.api.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryListRepository extends CrudRepository<GroceryList, Long> {
}
