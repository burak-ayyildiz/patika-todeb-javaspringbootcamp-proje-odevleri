package com.proje.odevi.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long itemId;
    private String name;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn()
    private Orders orders;
}
