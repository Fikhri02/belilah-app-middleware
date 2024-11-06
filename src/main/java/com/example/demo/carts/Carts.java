package com.example.demo.carts;

import com.example.demo.items.Items;
import com.example.demo.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Carts {

    @Id
    @SequenceGenerator(
            name="carts_id_sequence",
            sequenceName = "carts_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "carts_id_sequence"
    )

    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Items items;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users users;

    public Items getItem(){
        return this.items;
    }

    public Users getUser(){
        return this.users;
    }

}
