package htwberlin.webtech.web;

import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.api.Item;
import htwberlin.webtech.web.service.GroceryListService;
import htwberlin.webtech.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GroceryListRestController {
    @Autowired
    GroceryListService groceryListService;
    @Autowired
    ItemService itemService;


    @PostMapping("/api/groceryList")
    public GroceryList createGroceryList(@RequestBody GroceryList groceryList) {
        return groceryListService.createGroceryList(groceryList);
    }

    @PutMapping("/api/groceryList/{id}")
    public GroceryList updateGroceryList(@PathVariable Long id, @RequestBody GroceryList groceryList) {
        GroceryList existingGroceryList = groceryListService.getGroceryListById(id);
        if (existingGroceryList == null) {
            throw new RuntimeException("GroceryList not found" + id );
        }
        existingGroceryList.setTitle(groceryList.getTitle());

        return groceryListService.updateGroceryList(existingGroceryList);
    }

    @DeleteMapping("api/groceryList/{id}")
    public void deleteGroceryList(@PathVariable Long id) {
        groceryListService.deleteGroceryList(id);
    }

    @PutMapping("/api/groceryList/{groceryListId}/item")
    public GroceryList addItemToGroceryList(@PathVariable Long groceryListId, @RequestBody Item item) {

        return groceryListService.addItemToGroceryList(groceryListId, item);
    }

    @DeleteMapping("/api/{groceryListId}/item")
    public GroceryList removeItemFromGroceryList( Long groceryListId, @RequestBody Item item) {
        GroceryList groceryList = groceryListService.getGroceryListById(groceryListId);
        if (groceryList == null) {
            throw new RuntimeException("GroceryList not found: " + groceryListId);
        }
        Item savedItem = itemService.createItem(item);

        return groceryListService.updateGroceryList(groceryList);
    }
    @PostMapping("/api/item")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }
    @DeleteMapping("/api/item/{id}")
    public void deleteItem(Long id) {
        itemService.deleteItem(id);
    }

}
