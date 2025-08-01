package com.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CategoryNotFoundException extends RuntimeException {

	public CategoryNotFoundException(String msg) {
		super(msg);
		log.debug("Id is not Valid :: CATEGORYEXCEPTION");

	}

}
