package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dto.RequestCategory;
import com.dto.ResponseCategory;
import com.entity.Category;
import com.exception.CategoryNotFoundException;
import com.mysql.fabric.Response;
import com.repository.CategoryRepository;
import com.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceIMPL implements CategoryService {

	@Autowired
	private CategoryRepository cr;

	@Override
	public ResponseCategory registerCategoryINService(RequestCategory requestCategory) {

		log.info("Categories ::" + requestCategory);

		if (cr.existsByCategoryName(requestCategory.getCategoryName())) {

			System.out.println("already Exist");
//			 throw new CategoryAlreadyExist("Category Alredy Present");
		}

		Category category = new Category();

		ModelMapper model1 = new ModelMapper();
		Category catg1 = model1.map(requestCategory, Category.class);

		Category category2 = cr.save(catg1);

		System.out.println(category2);

		ModelMapper model2 = new ModelMapper();
		ResponseCategory responseCategory = model2.map(category2, ResponseCategory.class);

//		log.info("RepsonseCategory : " + responseCategory);

		return responseCategory;
	}

	@Override
	public List<ResponseCategory> getAllCategory(int page, int size) {

		PageRequest p = PageRequest.of(page, size);

		List<Category> list = cr.findAll(p).getContent();

		ModelMapper model1 = new ModelMapper();

		List<ResponseCategory> lresponse = list.stream().map(n -> model1.map(n, ResponseCategory.class))
				.collect(Collectors.toList());

		return lresponse;
	}

	@Override
	public ResponseCategory getSingleCateogry(long id) {
		Category categ = cr.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category is not found with this given ID"));
		ModelMapper model2 = new ModelMapper();
		ResponseCategory responseCategory = model2.map(categ, ResponseCategory.class);
		return responseCategory;
	}

	@Override
	public ResponseCategory updateCategoryInService(long id, RequestCategory requestCategory) {

		Category categ = cr.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category is not found with this given ID"));

		categ.setCategoryName(requestCategory.getCategoryName());

		Category categ2 = cr.save(categ);

		ModelMapper model2 = new ModelMapper();
		ResponseCategory responseCategory = model2.map(categ2, ResponseCategory.class);
		return responseCategory;
	}

	@Override
	public String deleteCategory(long id) {
		Category categ = cr.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category is not found with this given ID"));

		cr.delete(categ);

		return "Category Deleted";
	}
}
