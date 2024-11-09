package com.example.demo.carts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Carts, CartsKey> {
    // Deletes a cart by its composite key (itemId and userId)
    void deleteById(CartsKey cartId);
}
