package com.shop.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="El parámetro introducido no existe.")
public class NotFoundException extends Exception {


	private static final long serialVersionUID = -7191829263281102200L;

	public NotFoundException(String msg) {
		super(msg);
	}
	
	public NotFoundException() {
		super();
	}
}
