package com.framework.exception;

@SuppressWarnings("serial")
public class InvalidPathForException extends FrameworkException{
	
	public InvalidPathForException(String message) {
		super(message);
	}
	
	public InvalidPathForException(String message,Throwable cause) {
		super(message,cause);
	}

}
