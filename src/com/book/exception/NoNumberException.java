package com.book.exception;

public class NoNumberException  extends Exception{
	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
