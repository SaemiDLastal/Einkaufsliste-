package htwberlin.webtech.web;

import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.service.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryListRestController {

    @Autowired
    GroceryListService groceryListService;

    public GroceryListRestController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @PostMapping("/api/groceryList")
    public GroceryList createGroceryList(@RequestBody GroceryList groceryList) { return groceryListService.createGroceryList(groceryList);}

}
