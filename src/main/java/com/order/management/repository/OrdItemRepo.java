package com.order.management.repository;

import com.order.management.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdItemRepo extends JpaRepository<OrderItem,Long> {
}
