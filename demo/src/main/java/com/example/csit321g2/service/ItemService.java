package com.example.csit321g2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.csit321g2.entity.ItemEntity;
import com.example.csit321g2.exception.NameNotFoundException;
import com.example.csit321g2.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository irepo;

    public ItemService(ItemRepository irepo) {
        this.irepo = irepo;
    }

    // C - Create
    public ItemEntity postItem(ItemEntity item) {
        return irepo.save(item);
    }

    // R - Read
    public List<ItemEntity> getAllItems() {
        return irepo.findAll();
    }

    // U - Update
    public ItemEntity putItem(int id, ItemEntity newItemDetails) {
        ItemEntity item = irepo.findById(id)
                .orElseThrow(() -> new NameNotFoundException("Item " + id + " does not exist!"));

        item.setName(newItemDetails.getName());
        item.setUnit(newItemDetails.getUnit());
        item.setPrice(newItemDetails.getPrice());

        return irepo.save(item);
    }

    // D - Delete
    public String deleteItem(int id) {
        if (irepo.existsById(id)) {
            irepo.deleteById(id);
            return "Item " + id + " is successfully deleted!";
        } else {
            return "Item " + id + " does not exist!";
        }
    }
}