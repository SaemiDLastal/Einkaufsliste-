package htwberlin.webtech.web;

import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.api.Item;
import htwberlin.webtech.web.service.GroceryListService;
import htwberlin.webtech.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GroceryListRestController {
    @Autowired
    GroceryListService groceryListService;
    @Autowired
    ItemService itemService;


    @PostMapping("/api/groceryList")
    public GroceryList createGroceryList(@RequestBody GroceryList groceryList) {

        return groceryListService.createGroceryList(groceryList);
    }


    @GetMapping("/api/groceryList/{id}")
    public GroceryList findGroceryListById(@PathVariable Long id) {
        return groceryListService.findGroceryListById(id);
    }

    @GetMapping("/api/groceryList")
    public Iterable<GroceryList> getAllGroceryLists() {
        return groceryListService.getAllGroceryLists();
    }


    @PutMapping("/api/groceryList/{id}")
    public GroceryList updateGroceryList(@PathVariable Long id, @RequestBody GroceryList groceryList) {

        return groceryListService.updateGroceryList(id,groceryList);
    }

    @DeleteMapping("api/groceryList/{id}")
    public void deleteGroceryList(@PathVariable Long id) {
        groceryListService.deleteGroceryList(id);
    }

    @PutMapping("/api/groceryList/{groceryListId}/item")
    public GroceryList addItemToGroceryList(@PathVariable Long groceryListId, @RequestBody Item item) {
        return groceryListService.addItemToGroceryList(groceryListId, item);
    }
    @DeleteMapping("/api/groceryList/{groceryListId}/item/{itemId}")
    public void deleteItemFromGroceryList(@PathVariable Long groceryListId, @PathVariable Long itemId) {
        groceryListService.deleteItemFromGroceryList(groceryListId, itemId);
    }
    @PostMapping("/api/item")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }
    @DeleteMapping("/api/item/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

}
