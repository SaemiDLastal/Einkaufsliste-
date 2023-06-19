package htwberlin.webtech.web.service;

import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.api.Item;
import htwberlin.webtech.web.presistance.GroceryListRepository;
import htwberlin.webtech.web.presistance.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {

    @Autowired
    GroceryListRepository groceryListRepository;

    @Autowired
    ItemsRepository itemsRepository;

    public GroceryList createGroceryList(GroceryList groceryList) {

        return groceryListRepository.save(groceryList);
    }

    public List<GroceryList> getAllGroceryLists() {
        return (List<GroceryList>) groceryListRepository.findAll();
    }

    public GroceryList findGroceryListById(Long id) {
        return groceryListRepository.findById(id).orElse(null);
    }

    public GroceryList updateGroceryList(GroceryList groceryList) {

        return groceryListRepository.save(groceryList);
    }

    public void deleteGroceryList(Long id) {
        groceryListRepository.deleteById(id);
    }

    public GroceryList getGroceryListById(Long id) {
        return groceryListRepository.findById(id).orElse(null);
    }

   public GroceryList addItemToGroceryList(Long groceryListId, Item item) {
        /*Optional<GroceryList> optionalGroceryList = groceryListRepository.findById(groceryListId);
        if (optionalGroceryList.isPresent()) {
            GroceryList groceryList = optionalGroceryList.get();
            groceryList.addItem(item);
            groceryListRepository.save(groceryList);
            return groceryList;
        } else {
            throw new RuntimeException("GroceryList not found: " + groceryListId);
        }*/
       Optional<GroceryList> groceryList = groceryListRepository.findById(groceryListId);
       GroceryList groceryList1 = groceryList.get();
         groceryList1.addItem(item);
       System.out.println(groceryList1.toString());
             return groceryListRepository.save(groceryList1);


    }


}
