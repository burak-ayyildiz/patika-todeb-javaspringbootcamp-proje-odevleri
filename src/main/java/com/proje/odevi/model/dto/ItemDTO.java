package com.proje.odevi.model.dto;

import com.proje.odevi.model.entity.Orders;
import lombok.Data;

@Data
public class ItemDTO {
    private String name;
    private Orders orders;
    private double price;
}
