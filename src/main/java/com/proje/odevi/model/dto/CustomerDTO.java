package com.proje.odevi.model.dto;

import com.proje.odevi.model.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class CustomerDTO {

    private String name;
    private List<Orders> orders;
}
