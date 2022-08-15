package com.proje.odevi.service;


import com.proje.odevi.model.dto.ItemDTO;
import com.proje.odevi.model.entity.Item;
import com.proje.odevi.model.mapper.ItemMapper;
import com.proje.odevi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        List<Item> allItems = itemRepository.findAll();
        return allItems;
    }

    public Item getById(Long id) {
        Optional<Item> byId = itemRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Item not found!"));
    }

    public Item create(ItemDTO itemDTO) {
        Item item = ItemMapper.toEntity(itemDTO);
        return itemRepository.save(item);

    }

    public void delete(Long id) {
        getById(id);
        itemRepository.deleteById(id);
    }

    public Item update(String name, ItemDTO item) {
        Optional<Item> itemByName = itemRepository.findItemByName(name);
        if (!itemByName.isPresent())
            return null;
        Item updatedItem = itemByName.get();
        if (!StringUtils.isEmpty(item.getName())) {
            updatedItem.setName(item.getName());
        }
        if (!StringUtils.isEmpty(item.getName())) {
            updatedItem.setName(item.getName());
        }

        return itemRepository.save(updatedItem);
    }
}
