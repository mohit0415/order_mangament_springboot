package com.order.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;


    @Column(name = "ITEM_QTY")
    private Integer qty;

    @Column(name = "ITEM_PRICE")
    private Double price;


   @JoinColumn(name = "USER_ID")
   @ManyToOne
    private Users users;

   @JoinColumn(name = "PRODUCT_ID")
   @ManyToOne
    private Products products;
}
