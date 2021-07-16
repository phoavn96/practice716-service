package com.example.practice716service.service;

import com.example.practice716service.entity.Product;
import com.example.practice716service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.Array;
import java.util.List;

@WebService
@Component(value = "productService")
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @WebMethod
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    @WebMethod
    public boolean addProduct(Product p){

        productRepository.save(p);
        return true;
    }

    @WebMethod
    public Product sellProduct(int productId, int quantity) {
        Product product = productRepository.getById(productId);
        if (product != null) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                Product result = productRepository.save(product);
                return result;
            }
        }
        return null;
    }
}
