package com.example.cart_service.DTO;

import com.example.cart_service.Model.Product_Model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FakeStoreDTO {
    int id;
    int userid;
    String date;
    List<Product_Model> products;
}
