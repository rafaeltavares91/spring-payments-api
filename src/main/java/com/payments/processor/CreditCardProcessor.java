package com.payments.processor;

import com.payments.domain.Card;
import com.payments.domain.Payment;
import com.payments.domain.PaymentStatus;

import br.com.moip.validators.CreditCard;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class CreditCardProcessor implements PaymentProcessor {

	private CreditCardProcessor() { }
	
	public static CreditCardProcessor newIntance() {
		return new CreditCardProcessor();
	}
	
	@Override
	public String process(Payment payment) {
		PaymentStatus status = processStatus(payment.getCard());
		payment.setStatus(status);
		return status.getDescription();
	}

	private PaymentStatus processStatus(Card card) {
		CreditCard creditCard = new CreditCard(card.getNumber());
		PaymentStatus status = PaymentStatus.DENIED;
		if (creditCard.isValid()) {
			status = PaymentStatus.APPROVED;
		}
		return status;
	}

}