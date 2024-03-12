package com.example.cart_service.Service;

import com.example.cart_service.DTO.FakeStoreDTO;
import com.example.cart_service.Model.Product_Model;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreService implements ProductService{

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Product_Model> getAllProducts() {
        String url = "https://fakestoreapi.com/carts";
        ParameterizedTypeReference<List<FakeStoreDTO>> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<FakeStoreDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );
        List<FakeStoreDTO> fakeStoreProductDTOS = responseEntity.getBody();

        List<Product_Model> products = new ArrayList<>();
        if(fakeStoreProductDTOS == null) {
            return new ArrayList<>();
        }
        for(FakeStoreDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            Product_Model product = new Product_Model();
            product.setId(fakeStoreProductDTO.getId());
            product.setUserid(fakeStoreProductDTO.getUserid());
            product.setDate(fakeStoreProductDTO.getDate());
            product.setProducts(fakeStoreProductDTO.getProducts());
        }
        return products;

    }

    @Override
    public Product_Model getProductById(int id) {
        String url = "https://fakestoreapi.com/carts/" + id;
        FakeStoreDTO fakeStoreProductDTO = restTemplate.getForObject(
                url,
                FakeStoreDTO.class
        );
        Product_Model product = new Product_Model();
        assert fakeStoreProductDTO != null;
        product.setId(fakeStoreProductDTO.getId());
        product.setUserid(fakeStoreProductDTO.getUserid());
        product.setDate(fakeStoreProductDTO.getDate());
        product.setProducts(fakeStoreProductDTO.getProducts());
        return product;
    }

    @Override
    public Product_Model getInDateRange(String date1, String date2) {
        String url = "https://fakestoreapi.com/carts?" + date1 + "&" + date2;

        FakeStoreDTO fakeStoreProductDTO = restTemplate.getForObject(
                url,
                FakeStoreDTO.class
        );
        Product_Model product = new Product_Model();
        product.setId(fakeStoreProductDTO.getId());
        product.setUserid(fakeStoreProductDTO.getUserid());
        product.setDate(fakeStoreProductDTO.getDate());
        product.setProducts(fakeStoreProductDTO.getProducts());
        return product;
    }

    @Override
    public List<Product_Model> getProductsByUser(int id) {
        String url = "https://fakestoreapi.com/carts/user/" + id;
        ParameterizedTypeReference<List<FakeStoreDTO>> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<FakeStoreDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );
        List<FakeStoreDTO> fakeStoreProductDTOS = responseEntity.getBody();

        List<Product_Model> products = new ArrayList<>();
        if(fakeStoreProductDTOS == null) {
            return new ArrayList<>();
        }
        for(FakeStoreDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            Product_Model product = new Product_Model();
            product.setId(fakeStoreProductDTO.getId());
            product.setUserid(fakeStoreProductDTO.getUserid());
            product.setDate(fakeStoreProductDTO.getDate());
            product.setProducts(fakeStoreProductDTO.getProducts());
        }
        return products;
    }

    @Override
    public Product_Model createProduct(Product_Model product) {
        String url = "https://fakestoreapi.com/carts";

        restTemplate.postForObject(
                url,
                product,
                FakeStoreDTO.class
        );
        FakeStoreDTO fakeStoreProductDTO = new FakeStoreDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setUserid(product.getUserid());
        fakeStoreProductDTO.setDate(product.getDate());
        fakeStoreProductDTO.setProducts(product.getProducts());

        return product;
    }

    @Override
    public String updateProduct(int id, Product_Model product) {
        FakeStoreDTO fakeStoreProductDTO = new FakeStoreDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setUserid(product.getUserid());
        fakeStoreProductDTO.setDate(product.getDate());

        String url = "https://fakestoreapi.com/carts/" + id;
        restTemplate.put(
                url,
                fakeStoreProductDTO
        );

        return "Product updated"+ id + "successfully";
    }

    @Override
    public String deleteProduct(int id) {
        String url = "https://fakestoreapi.com/carts/" + id;
        restTemplate.delete(url);
        return "Product deleted successfully";
    }
}
