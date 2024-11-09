package com.example.demo.addresses;

import com.example.demo.users.Users;
import com.example.demo.users.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressesService {

    AddressesRepository addressesRepository;
    UsersRepository usersRepository;

    @Autowired
    public AddressesService(AddressesRepository addressesRepository, UsersRepository usersRepository)
    {
        this.addressesRepository = addressesRepository;
        this.usersRepository = usersRepository;
    }

//    @Transactional
//    public Addresses addAddressToUser(Addresses addresses){
//        Users users = usersRepository.findById(addresses.getcUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));;
//        addresses.setUsers(users);
//
//        addressesRepository.save(addresses);
//        return addresses;
//    }
}
