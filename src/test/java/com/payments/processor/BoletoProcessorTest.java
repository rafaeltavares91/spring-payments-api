package com.payments.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.payments.domain.Boleto;
import com.payments.domain.Payment;
import com.payments.processor.BoletoProcessor;
import com.payments.processor.PaymentProcessor;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class BoletoProcessorTest {

	@Test
    public void process() {
		PaymentProcessor boletoProcessor = BoletoProcessor.newIntance();

		Payment payment = Payment.builder().build();
		
		String result = boletoProcessor.process(payment);
		
		assertEquals(Boleto.GENERATED_RESULT_NUMBER, result);
    }
	
}
