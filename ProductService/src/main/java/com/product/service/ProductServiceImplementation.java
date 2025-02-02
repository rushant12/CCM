package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.model.UserResponse;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public UserResponse addProduct(Product product) {
		
		UserResponse userResponse = new UserResponse();
		Product addedProduct = productRepository.save(product);
		if(addedProduct == null)
		{
			userResponse.setCode("Failed");
			userResponse.setMessage("Product cannot be added");
		}
		
		userResponse.setMessage("Product Added !");
		userResponse.setCode("Success");
		
		return userResponse;
	}

	@Override
	public Product getProductById(int id) {
	Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found !"));
	return product;	
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public String deleteProductById(int id) {
		Product product = productRepository.findById(id).get();	
		productRepository.delete(product);
		return "Product Deleted";
	}
	
	
	
	

}
