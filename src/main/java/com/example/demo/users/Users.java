package com.example.demo.users;

import jakarta.persistence.*;

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

}