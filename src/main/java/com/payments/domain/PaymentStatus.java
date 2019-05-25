package com.payments.domain;

/**
 * 
 * @author Rafael Tavares
 *
 */
public enum PaymentStatus {

	APPROVED(1, "Approved"), DENIED(2, "Denied"), CANCELLED(3, "Cancelled");

	private int code;
	private String description;

	private PaymentStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
	
}