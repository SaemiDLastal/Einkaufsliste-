package htwberlin.webtech.web.service;

import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.api.Item;
import htwberlin.webtech.web.presistance.GroceryListRepository;
import htwberlin.webtech.web.presistance.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public GroceryList updateGroceryList(Long groceryListId,GroceryList groceryList) {
        GroceryList existingGroceryList= groceryListRepository.findById(groceryListId).orElse(null);
        if (existingGroceryList == null) {
            throw new RuntimeException("GroceryList not found" + groceryListId );
        }
        existingGroceryList.setTitle(groceryList.getTitle());
        existingGroceryList.setItemList(groceryList.getItemList());

        return groceryListRepository.save(existingGroceryList);
    }

    public void deleteGroceryList(Long id) {
        groceryListRepository.deleteById(id);
    }

    public void deleteItemFromGroceryList(Long groceryListId, Long itemId) {
        GroceryList groceryList = groceryListRepository.findById(groceryListId).orElse(null);
        if (groceryList == null) {
            throw new RuntimeException("GroceryList not found: " + groceryListId);
        }
        Item item = itemsRepository.findById(itemId).orElse(null);
        if (item == null) {
            throw new RuntimeException("Item not found: " + itemId);
        }
        List<Item> itemList = groceryList.getItemList();
        itemList.remove(item);
        groceryList.setItemList(itemList);
        groceryListRepository.save(groceryList);
    }

   public GroceryList addItemToGroceryList(Long groceryListId, Item item) {
         GroceryList groceryList = groceryListRepository.findById(groceryListId).orElse(null);
            if (groceryList == null) {
                throw new RuntimeException("GroceryList not found: " + groceryListId);
            }
            Item existingItem = itemsRepository.findByName(item.getName());
            if( existingItem != null && existingItem.getName().equals(item.getName())){
                groceryList.addItem(existingItem);
            }else {
                groceryList.addItem(item);
            }

          groceryListRepository.save(groceryList);

          return groceryList;
    }


}
