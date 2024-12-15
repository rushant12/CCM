package com.product.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.model.UserResponse;
import com.product.service.ProductService;

@RestController
@RequestMapping (value = "/api/v1/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping (value = "/add")
	public ResponseEntity<UserResponse> addProduct(@RequestBody Product product)
	{
		UserResponse userResponse = productService.addProduct(product);
		
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
	}
	
	@GetMapping (value = "/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id)
	{
		Product product = productService.getProductById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		return new ResponseEntity<String>(productService.deleteProductById(id), HttpStatus.OK);	
	}
	

}
