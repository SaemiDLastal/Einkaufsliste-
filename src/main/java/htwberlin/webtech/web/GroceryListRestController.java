package htwberlin.webtech.web;

import htwberlin.webtech.web.api.Items;
import htwberlin.webtech.web.service.ItemsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryListRestController {
    ItemsService itemsService;


    @PostMapping("/api/grocery-lists")
    public Items createItems(@RequestBody Items items) {
        return itemsService.save(items);

    }

}
