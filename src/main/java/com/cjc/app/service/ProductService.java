package com.cjc.app.service;

import java.util.List;

import com.cjc.app.model.Product;

public interface ProductService {

	List<Product> getAllProcduct();

	Product getProduct(int id);

	Boolean deleteProduct(int id);

	Product updateProduct(int id, Product product);

	Product addProduct(Product product);

	Product editProduct(int id, Product product);

}
