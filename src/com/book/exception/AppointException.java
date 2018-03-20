package com.book.exception;

public class AppointException extends Exception{
	//预约义务异常

		public AppointException(String message) {
			super(message);
		}

		public AppointException(String message, Throwable cause) {
			super(message, cause);
		}
	 
}
