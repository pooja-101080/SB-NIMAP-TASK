package com.controller;

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

import com.dto.RequestCategory;
import com.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@Tag(name = "CATEGORIES-API")
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	@Operation(summary = "Get All Categories", description = "Get All Categories Using pagination page and Size")
	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategories(@RequestParam("page") int page, @RequestParam("size") int size) {

		return new ResponseEntity(cs.getAllCategory(page, size), HttpStatus.OK);
	}

	@Operation(summary = "Create Categopry", description = "Create new Category ")
	@PostMapping("/categories")
	public ResponseEntity<?> Addcategories(@RequestBody RequestCategory requestCategory) {

		log.info("Create Category :: " + requestCategory);

		return new ResponseEntity(cs.registerCategoryINService(requestCategory), HttpStatus.OK);
	}



	@Operation(summary = "get Category by id", description = "Get  Category by ID")
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getSingleCategory(@PathVariable("id") int id) {

		return new ResponseEntity(cs.getSingleCateogry(id), HttpStatus.OK);
	}

	@Operation(summary = "Update Category by id", description = "Update Category by id")
	@PutMapping("/categories/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") int id, @RequestBody RequestCategory requestCategory) {

		return new ResponseEntity(cs.updateCategoryInService(id, requestCategory), HttpStatus.OK);
	}

	@Operation(summary = "Delete Category by id", description = "Delete Category by id")
	@DeleteMapping("/categories/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {

		return new ResponseEntity(cs.deleteCategory(id), HttpStatus.OK);
	}

}
