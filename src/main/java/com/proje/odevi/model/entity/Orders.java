package com.proje.odevi.model.entity;

import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "orders")
public class Orders {
    @Id
    @Column(name = "order_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String name;

    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
   private List<Item> items;

}
