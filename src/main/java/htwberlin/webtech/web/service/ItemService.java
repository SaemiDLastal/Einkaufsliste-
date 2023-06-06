package htwberlin.webtech.web.service;

import htwberlin.webtech.web.api.Item;
import htwberlin.webtech.web.presistance.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Item getItems(Long itemsId) {
        return itemsRepository.findById(itemsId).orElseThrow(() -> new RuntimeException("Item-ID not found: "+ itemsId));
    }

    public Item createItem(Item item) {
        return itemsRepository.save(item);
    }

    public Item updateItem(Long groceryListId, Long itemId, Item item) {
        Item itemToUpdate = itemsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item-ID not found: "+ itemId));
        itemToUpdate.setName(item.getName());
        itemToUpdate.setCategory(item.getCategory());
        return itemsRepository.save(itemToUpdate);
    }

    public Item deleteItem(Long itemId) {
        Item item = itemsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item-ID not found: "+ itemId));
        itemsRepository.deleteById(itemId);
        return item;
    }


}
