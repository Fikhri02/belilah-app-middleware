package com.example.demo.addresses;

import com.example.demo.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
public class Addresses {
    @Id
    @SequenceGenerator(
            name="addresses_id_sequence",
            sequenceName = "addresses_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "addresses_id_sequence"
    )

    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference // Prevents circular reference in serialization
    private Users users;

    private String line_1;
    private String line_2;
    private String postcode;
    private String city;
    private String state;
    private String country;
    private String label;
    private boolean isActive;


    public long getId() {
        return id;
    }

    public String getLine_1() {
        return line_1;
    }

    public String getLine_2() {
        return line_2;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLabel() {
        return label;
    }

    public String getState() {
        return state;
    }

    public Users getUsers(){
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }



    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }
}
