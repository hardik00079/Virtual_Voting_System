package com.fdmgroup.vvs.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends Exception {

	public CandidateNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
