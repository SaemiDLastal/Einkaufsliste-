package htwberlin.webtech.web.service;

import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.presistance.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GroceryListService {

    @Autowired
    GroceryListRepository groceryListRepository;

    public GroceryList createGroceryList(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    public Iterable<GroceryList> getAllGroceryLists() {
        return groceryListRepository.findAll();
    }

    public GroceryList getGroceryListById(Long id) {
        return groceryListRepository.findById(id).get();
    }

    public GroceryList updateGroceryListById(Long id, GroceryList groceryList) {
        GroceryList groceryListToUpdate = getGroceryListById(id);

        groceryListToUpdate.setTitle(groceryList.getTitle());
        groceryListToUpdate.setItems(groceryList.getItems());
        return groceryListRepository.save(groceryListToUpdate);
    }

    public GroceryList deleteGroceryListById(Long id) {
        GroceryList groceryList = getGroceryListById(id);
        groceryListRepository.deleteById(id);
        return groceryList;
    }

}
