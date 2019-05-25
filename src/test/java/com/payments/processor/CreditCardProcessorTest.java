package com.payments.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.payments.domain.Card;
import com.payments.domain.Payment;
import com.payments.domain.PaymentStatus;
import com.payments.domain.PaymentType;
import com.payments.processor.CreditCardProcessor;
import com.payments.processor.PaymentProcessor;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class CreditCardProcessorTest {

	private static final String VALID_CREDIT_CARD_NUMBER = "5424606926573115";
	
	private static final String INVALID_CREDIT_CARD_NUMBER = "12345";
	
	@Test
    public void processCreditCardApproved() {
		PaymentProcessor boletoProcessor = CreditCardProcessor.newIntance();

		Payment payment = Payment.builder()
    			.id(1)
    			.type(PaymentType.CREDIT_CARD)
    			.card(Card.builder()
    					.number(VALID_CREDIT_CARD_NUMBER)
    					.build())
    			.build();
		
		String result = boletoProcessor.process(payment);
		
		assertEquals(PaymentStatus.APPROVED.getDescription(), result);
    }
	
	@Test
    public void processCreditCardDenied() {
		PaymentProcessor boletoProcessor = CreditCardProcessor.newIntance();

		Payment payment = Payment.builder()
    			.id(1)
    			.type(PaymentType.CREDIT_CARD)
    			.card(Card.builder()
    					.number(INVALID_CREDIT_CARD_NUMBER)
    					.build())
    			.build();
		
		String result = boletoProcessor.process(payment);
		
		assertEquals(PaymentStatus.DENIED.getDescription(), result);
    }
	
}
