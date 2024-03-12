package com.example.cart_service.Controller;

import com.example.cart_service.Model.Product_Model;
import com.example.cart_service.Service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CartController {
    ProductService productServices;

    public CartController(ProductService productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/carts")
    public List<Product_Model> getAllProducts() {
        return productServices.getAllProducts();
    }
    @GetMapping("/carts/{id}")
    public Product_Model getProductById(@PathVariable int id) {
        return productServices.getProductById(id);
    }
    @GetMapping("/carts/date/{date1}/{date2}")
    public Product_Model getInDateRange(@PathParam("date1") String date1, @PathParam("date2") String date2){
        return productServices.getInDateRange(date1, date2);
    }
    @GetMapping("/carts/user/{id}")
    public List<Product_Model> getProductsByUser(@PathVariable int id) {
        return productServices.getProductsByUser(id);
    }
    @PostMapping("/carts")
    public Product_Model createProduct(@PathVariable Product_Model product) {
        return productServices.createProduct(product);
    }
    @PutMapping("/carts/update/{id}")
    public String updateProduct(@PathVariable("id") int id, @PathVariable Product_Model product) {
        return productServices.updateProduct(id, product);
    }
    @DeleteMapping("/carts/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        return productServices.deleteProduct(id);
    }

}
