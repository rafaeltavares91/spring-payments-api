package com.payments.processor;

import com.payments.domain.Boleto;
import com.payments.domain.Payment;
import com.payments.domain.PaymentStatus;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class BoletoProcessor implements PaymentProcessor {

	private BoletoProcessor() { }
	
	public static BoletoProcessor newIntance() {
		return new BoletoProcessor();
	}
	
	@Override
	public String process(Payment payment) {
		Boleto boleto = Boleto.builder()
			.number(Boleto.GENERATED_RESULT_NUMBER)
			.build();
		payment.setBoleto(boleto);
		payment.setStatus(PaymentStatus.APPROVED);
		return boleto.getNumber();
	}
	
}