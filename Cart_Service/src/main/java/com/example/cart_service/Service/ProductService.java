package com.example.cart_service.Service;

import com.example.cart_service.Model.Product_Model;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product_Model> getAllProducts();
    Product_Model getProductById(int id);
    Product_Model getInDateRange(String date1, String date2);
    List<Product_Model> getProductsByUser(int id);
    Product_Model createProduct(Product_Model product);
    String updateProduct(int id, Product_Model product);
    String deleteProduct(int id);

}
