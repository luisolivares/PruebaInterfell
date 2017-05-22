package com.rest.rest.bean;

import java.io.Serializable;

public class AnswerMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 56474044558604326L;
	private Integer number;
	private String message;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
