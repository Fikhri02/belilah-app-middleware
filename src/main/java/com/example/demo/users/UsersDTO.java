package com.example.demo.users;
import com.example.demo.carts.CartMapper;
import com.example.demo.carts.Carts;
import com.example.demo.carts.CartsDTO;
import org.apache.catalina.User;
import com.example.demo.carts.CartsDTO;

import java.util.Set;

public class UsersDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String  fullname;
    private String password;
    private String token;

    private Set<CartsDTO> carts;

    public UsersDTO(Users users){
        this.firstName = users.getFirstName();
        this.lastName = users.getLastName();
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.fullname = firstName + lastName;
        this.carts = CartMapper.cartsToCartDTO(users.getCarts());

    }


    public String getFullname(){
        return this.fullname;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
    public String getToken(){
        return this.token;
    }

    public Set<CartsDTO> getCarts(){
        return this.carts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
