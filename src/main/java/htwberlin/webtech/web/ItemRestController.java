package htwberlin.webtech.web;

import htwberlin.webtech.web.api.Item;
import htwberlin.webtech.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemRestController {
    @Autowired
    ItemService itemService;

   public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/api/item")
    public Item createItems(@RequestBody Item item) {
        return itemService.createItem(item);

    }

   @GetMapping("/api/item")
    public Item getItems(@RequestParam Long itemsId) {
        return itemService.getItems(itemsId);
    }

}

