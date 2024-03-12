package com.example.cart_service;

import com.example.cart_service.Model.Product_Model;
import com.example.cart_service.Service.FakeStoreService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
        FakeStoreService fakeStoreService = new FakeStoreService();
        List<Product_Model> products = fakeStoreService.getAllProducts();
        for (Product_Model product : products) {
            System.out.println(product);
        }


    }

    //print the message
}
