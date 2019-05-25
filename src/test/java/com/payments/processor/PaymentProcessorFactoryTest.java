package com.payments.processor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.payments.domain.PaymentType;
import com.payments.processor.BoletoProcessor;
import com.payments.processor.CreditCardProcessor;
import com.payments.processor.PaymentProcessor;
import com.payments.processor.PaymentProcessorFactory;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class PaymentProcessorFactoryTest {

	@Test
    public void getBoletoProcessor() {
		PaymentProcessor boletoProcessor = PaymentProcessorFactory.getProcessor(PaymentType.BOLETO);

        assertThat(boletoProcessor).isInstanceOf(BoletoProcessor.class);
    }
	
	@Test
    public void getCreditCardProcessor() {
		PaymentProcessor boletoProcessor = PaymentProcessorFactory.getProcessor(PaymentType.CREDIT_CARD);

        assertThat(boletoProcessor).isInstanceOf(CreditCardProcessor.class);
    }
	
}