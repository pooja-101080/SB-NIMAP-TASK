package com.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.dto.RequestCategory;
import com.dto.ResponseCategory;

public interface CategoryService {

	ResponseCategory registerCategoryINService(RequestCategory requestCategory);

	List<ResponseCategory> getAllCategory(int page, int size);

	ResponseCategory getSingleCateogry(long id);

	ResponseCategory updateCategoryInService(long id, RequestCategory requestCategory);

	String deleteCategory(long id);

}
