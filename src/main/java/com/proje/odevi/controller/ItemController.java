package com.proje.odevi.controller;


import com.proje.odevi.model.dto.ItemDTO;
import com.proje.odevi.model.entity.Item;
import com.proje.odevi.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/all")
    public ResponseEntity getAllItems() {
        List<Item> allItems = itemService.getAllItems();
        return ResponseEntity.ok(allItems);
    }


    @GetMapping("/{id}")
    public ResponseEntity getItemById(@PathVariable("id") Long id) {
        Item byId;
        try {
            byId = itemService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewItem(@RequestBody ItemDTO item) {
        Item respItem = itemService.create(item);
        if (respItem == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Item could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respItem);
    }

    @DeleteMapping
    public ResponseEntity deleteItem(@RequestParam(name = "id") Long id) {
        try {
            itemService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Related Item deleted successfully");
    }

    @PutMapping("/{item}")
    public ResponseEntity updateItem(
            @PathVariable String name,
            @RequestBody ItemDTO item) {
        Item update = itemService.update(name, item);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Item could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

}
