package com.example.demo.ordersLine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersLineRepository extends JpaRepository<OrdersLine, Long> {
}

