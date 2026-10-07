package com.example.firstspringbootapp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstspringbootapp.entity.ItemEntity;
import com.example.firstspringbootapp.exception.NameNotFoundException;
import com.example.firstspringbootapp.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository irepo;

    public ItemService(ItemRepository irepo) {
    // TODO Auto-generated constructor stub
    this.irepo = irepo;
}

//C - Create
//method will return the student being added
public ItemEntity postItem(ItemEntity Item) {
    return irepo.save(Item);
}

//R - Read
public List<ItemEntity> getAllItems(){
    return irepo.findAll();
}

//U - Update
@SuppressWarnings("finally")
public ItemEntity putItem(int id, ItemEntity newItemDetails) {
    ItemEntity Item = new ItemEntity();
    try {
    //findById is a pre-defined method of the repository
        Item = irepo.findById(id).get();
        Item.setName(newItemDetails.getName());
        Item.setUnit(newItemDetails.getUnit());
        Item.setPrice(newItemDetails.getPrice());
    }catch(NoSuchElementException ex) {
        throw new NameNotFoundException("Item " + id + " does not exist!");
    }finally {
        return irepo.save(Item);
    }
}

//D - Delete
public String deleteItem(int id) {
    String msg = "";
    if (irepo.findById(id) != null) {
        irepo.deleteById(id);
        msg = "Item " + id + " is successfully deleted!";
    }else
    msg = id + "does not exist!";
    return msg;
}
}