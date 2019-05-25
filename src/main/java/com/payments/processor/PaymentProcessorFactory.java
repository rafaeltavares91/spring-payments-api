package com.payments.processor;

import com.payments.domain.PaymentType;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class PaymentProcessorFactory {

	private PaymentProcessorFactory() { }
	
	public static PaymentProcessor getProcessor(PaymentType paymentType) {
		PaymentProcessor paymentProcessor = null;
		switch (paymentType) {
			case BOLETO:
				paymentProcessor = BoletoProcessor.newIntance();
				break;
			case CREDIT_CARD:
				paymentProcessor = CreditCardProcessor.newIntance();
				break;
			default:
				throw new IllegalArgumentException();
		}
		return paymentProcessor;
	}
	
}
