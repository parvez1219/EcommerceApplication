package com.EcommerceApplication.EcommerceApplication.Model;
import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cartTotal;

    @OneToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();
}
