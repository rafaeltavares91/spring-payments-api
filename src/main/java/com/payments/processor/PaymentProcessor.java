package com.payments.processor;

import com.payments.domain.Payment;

/**
 * 
 * @author Rafael Tavares
 *
 */
public interface PaymentProcessor {

	public String process(Payment payment);
	
}