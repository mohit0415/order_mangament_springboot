package com.order.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "ORDER_TOTAL")
    private Double total_amt;
    @Column(name = "ORDER_STATUS")
    private String Status;
    @Column(name = "ORDER_CREATE_AT")
    private LocalDateTime created_at;


    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private Users users;
}
