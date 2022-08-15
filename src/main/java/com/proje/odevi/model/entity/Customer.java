package com.proje.odevi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id; //customer_id , id
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private List<Orders> orders;
}
