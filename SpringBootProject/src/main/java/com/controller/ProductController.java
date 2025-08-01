package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RequestProduct;
import com.dto.ResponseProduct;
import com.service.productService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@Tag(name = "PRODUCT-API")
public class ProductController {

	@Autowired
	private productService ps;
	
	@Operation(summary = "Get ALL products", description = "Get All Products Using pagination page and Size")
	@GetMapping("/product")
	public ResponseEntity<?> getAllProduct(@RequestParam("page") int page, @RequestParam("size") int size) {

		List<ResponseProduct> rp = ps.getAllProductsInService(page, size);

		System.out.println(rp);

		return new ResponseEntity(rp, HttpStatus.OK);
	}

	@Operation(summary = "Create product", description = "Create Products")
	@PostMapping("/product")
	public ResponseEntity<?> addproduct(@RequestBody RequestProduct requestproduct) {
		log.info("product Details :: " + requestproduct);

		ResponseProduct rp = ps.addProduct(requestproduct);

		System.out.println(rp);

		return new ResponseEntity(rp, HttpStatus.OK);
	}

	@Operation(summary = "Get product by id", description = "Get  Product by ID")
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") long id) {

		ResponseProduct rp = ps.getProduct(id);

		System.out.println(rp);

		return new ResponseEntity(rp, HttpStatus.OK);
	}

	@Operation(summary = "Delete product by id", description = "Delete Single Product Using ID")
	@DeleteMapping("/product/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {

		String result = ps.deleteProductInService(id);

		return new ResponseEntity(result, HttpStatus.OK);
	}

	@Operation(summary = "Update product by id", description = "Update Product")
	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody RequestProduct requestproduct) {
		log.info("product Details :: " + requestproduct);

		ResponseProduct rp = ps.updateProductInService(id, requestproduct);

		System.out.println(rp);

		return new ResponseEntity(rp, HttpStatus.OK);
	}



}
