package com.example.demo.users;

import com.example.demo.carts.Carts;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class Users {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String  fullname;
    private String password;
    private String token;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Carts> carts;

//    public Users(String fullname, String password){
//        this.fullname = fullname;
//        this.password = password;
//    }

    public Users(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.fullname = firstName + lastName;

    }

    public Users(){
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

    public Set<Carts> getCarts(){
        return this.carts;
    }

}
