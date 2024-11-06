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
    @Query("SELECT u from Users u where u.fullname =:users AND u.password =:password")
    Optional<Users> findUserByPassword(@Param("users") String users, @Param("password") String password);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.carts c LEFT JOIN FETCH c.items WHERE u.id = :userId")
//    Optional<Users> findByIdWithUserCarts(@Param("userId") Long userId);

    @EntityGraph(attributePaths = "carts")
    Optional<Users> findById(Long userId);
}


