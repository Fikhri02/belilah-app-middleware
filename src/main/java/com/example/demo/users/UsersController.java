package com.example.demo.users;
import com.example.demo.carts.CartsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    UsersController(UsersService usersService)
    {
        this.usersService = usersService;
    }

    @CrossOrigin
    @PostMapping(path = "/verify")
    public UsersDTO verifyUser(@RequestBody Users user)
    {
        return usersService.verifyUser(user);
    }

    @CrossOrigin
    @PostMapping(path = "/register")
    public Users registerUser(@RequestBody Users user)
    {
        return usersService.registerUser(user);
    }

    @CrossOrigin
    @PostMapping(path = "/get-cart")
    public UsersDTO getCarts(@RequestBody Users user)
    {
        return usersService.getUsersCarts(user);
    }
}
