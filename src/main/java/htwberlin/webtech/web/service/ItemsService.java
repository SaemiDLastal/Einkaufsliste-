package htwberlin.webtech.web.service;

import htwberlin.webtech.web.api.Items;
import htwberlin.webtech.web.presistance.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    private ItemsRepository itemsRepository;


    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Iterable<Items> getItems(Long itemsId) {
        return itemsRepository.findByGroceryListId(itemsId);
    }

    public Items createItem(Items items) {
        return itemsRepository.save(items);
    }

    public Items updateItem(Long groceryListId, Long itemId, Items items) {
        Items itemToUpdate = itemsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item-ID not found: "+ itemId));
        itemToUpdate.setName(items.getName());
        itemToUpdate.setCategory(items.getCategory());
        return itemsRepository.save(itemToUpdate);
    }

    public Items deleteItem(Long groceryListId, Long itemId) {
        Items itemToDelete = itemsRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item-ID not found: "+ itemId));
        itemsRepository.deleteById(itemId);
        return itemToDelete;
    }



}
