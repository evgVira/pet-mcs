package com.example.orderservicemicroservice.repositories;

import com.example.orderservicemicroservice.modles.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
