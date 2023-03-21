package com.devmaicon.workshopmongo.services.exception;

public class ObjectNotFoudExeception extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoudExeception(String msg) {
		super(msg);
	}

}
