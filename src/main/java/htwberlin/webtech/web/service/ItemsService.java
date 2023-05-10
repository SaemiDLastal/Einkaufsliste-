package htwberlin.webtech.web.service;

import htwberlin.webtech.web.api.Items;
import htwberlin.webtech.web.presistance.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    @Autowired
    ItemsRepository itemsRepository;

    public Items save(Items items) {
        return itemsRepository.save(items);
    }

    public Items findById(Long id) {
        return itemsRepository.findById(id).get();
    }

    public Items deleteById(Long id) {
        Items items = findById(id);
        itemsRepository.deleteById(id);
        return items;
    }
}
