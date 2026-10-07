package com.example.firstspringbootapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.firstspringbootapp.entity.ItemEntity;
import com.example.firstspringbootapp.service.ItemService;

@RestController
//@RequestMapping(method=RequestMethod.GET, path="/item/api")
@RequestMapping("/item/api")
@CrossOrigin(origins = "http://localhost:3307")

public class ItemController {
    @Autowired
    private final ItemService iserv;

    public ItemController(ItemService iserv) {
        // TODO Auto-generated constructor stub
        this.iserv = iserv;
}

@GetMapping("/printAuthor")
public String printAuthor() {
    return "Louraine Mae D. Javines";
}

//C - Create
@PostMapping("/postNewItem")
public ItemEntity postItem(@RequestBody ItemEntity Item) {
    return iserv.postItem(Item);
}

//R - Read
@GetMapping("/getAllItems")
public List<ItemEntity> getAllItems(){
    return iserv.getAllItems();
}

//U - Update
@PutMapping("/putItem")
public ItemEntity putItem(@RequestParam int id, @RequestBody
ItemEntity newItemDetails) {
    return iserv.putItem(id, newItemDetails);
}   

//D - Delete
@DeleteMapping("/deleteItem/{id}")
public String deleteItem(@PathVariable int id) {
    return iserv.deleteItem(id);
}

}