package com.example.cart_service.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Product_Model {
    private int id;
    private int userid;
   private String name;
    private String date;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
    private int quantity;
    private List<Product_Model> products;
}
