package com.example.demo.users;

import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u LEFT JOIN u.addresses a ON a.isActive = true  WHERE u.email = :email AND u.password = :password ")
    Optional<Users> findUserByPassword(@Param("email") String users, @Param("password") String password);

    Optional<Users> findByEmail(String email);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.carts c LEFT JOIN FETCH c.items WHERE u.id = :userId")
//    Optional<Users> findByIdWithUserCarts(@Param("userId") Long userId);

    @EntityGraph(attributePaths = {"carts", "carts.items", "addresses"})
    Optional<Users> findCartsById(Long userId);
}


