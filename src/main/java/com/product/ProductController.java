package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/view/all")
    public List<Product> fetchAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return productList;
    }

    @GetMapping("/view/{productId}")
    public ResponseEntity<Product> fetchProductDetails(@PathVariable("productId") long productId) {

        Product product = productService.getProductById(productId);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping("/save")
    public ResponseEntity<Product> addProduct( @Validated @RequestBody Product product) {

        Product newProduct = productService.saveProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("/update")
    public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> removeProduct(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Product Deleted Successfully.", HttpStatus.OK);
        return responseEntity;
    }


}



