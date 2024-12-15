package com.product.service;

import java.util.List;

import com.product.entity.Product;
import com.product.model.UserResponse;

public interface ProductService {
	
	UserResponse addProduct(Product product);
	
	Product getProductById(int id);
	
	List<Product> getAllProduct();
	
	String deleteProductById(int id);

}
