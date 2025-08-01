package com.dto;

import com.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestProduct {

	private long productID;

	private String productName;

	private String productType;

	private String categoryName;
}
