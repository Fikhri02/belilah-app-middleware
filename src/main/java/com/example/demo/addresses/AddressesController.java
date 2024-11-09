package com.example.demo.addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/addresses")
public class AddressesController {

    private final AddressesService addressesService;

    @Autowired
    public AddressesController(AddressesService addressesService)
    {
        this.addressesService = addressesService;
    }

    @CrossOrigin
    @PostMapping(path = "/add-address")
    public Addresses addUserAddress(@RequestBody Addresses addresses)
    {
        return addressesService.addAddressToUser(addresses);
    }

}
