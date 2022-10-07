package com.product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product getProductById(long productId);

    public Product saveProduct(Product product);

    public Product updateProduct(Product product);

    public void deleteProduct(long productId);

}
