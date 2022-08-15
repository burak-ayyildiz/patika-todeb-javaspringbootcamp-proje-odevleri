package com.proje.odevi.model.mapper;

import com.proje.odevi.model.dto.ItemDTO;
import com.proje.odevi.model.entity.Item;

public class ItemMapper {
    public ItemDTO toDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(itemDTO.getName());
        itemDTO.setOrders(itemDTO.getOrders());
        itemDTO.setPrice(itemDTO.getPrice());
        return itemDTO;
    }

    public static Item toEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setOrders(itemDTO.getOrders());
        item.setPrice(item.getPrice());
        return item;
    }

}


