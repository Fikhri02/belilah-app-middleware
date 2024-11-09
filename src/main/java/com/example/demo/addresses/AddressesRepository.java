package com.example.demo.addresses;


import com.example.demo.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long> {

    Optional<Addresses> findTopByUsersIdAndIsActiveTrue(long userId);
}
