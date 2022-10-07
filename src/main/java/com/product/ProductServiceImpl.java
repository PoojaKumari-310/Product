package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product Not existing with id:" + productId);
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product Not found with id: " + product.getProductId());
        }

        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product Not found with id: " + productId);
        }

        productRepository.deleteById(productId);

    }
}
