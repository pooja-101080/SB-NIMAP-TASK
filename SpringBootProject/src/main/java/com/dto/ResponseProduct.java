package com.dto;

import java.time.Instant;

import com.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseProduct {

	@JsonProperty(value = "productName")
	private String productName;

	@JsonProperty(value = "productType")
	private String productType;

	@JsonProperty(value = "categoryID")
	private long categoryID;

	@JsonProperty(value = "CategoryName")
	private String CategoryName;

	@JsonProperty(value = "createdTime")
	private Instant createdTime;

	@JsonProperty(value = "updatedTime")
	private Instant updatedTime;

}
