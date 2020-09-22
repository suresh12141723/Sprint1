package com.cg.user.exception;

public class NoUserFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoUserFoundException(String msg) {
		super(msg);
	}
	public  NoUserFoundException(String msg,Throwable S) {
		super(msg,S);
	}

}
