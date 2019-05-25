package com.payments.mapper;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.payments.domain.Payment;
import com.payments.domain.PaymentStatus;
import com.payments.domain.PaymentType;
import com.payments.dto.PaymentDTO;
import com.payments.mapper.PaymentMapper;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class PaymentMapperTest {
	
	private static final Integer ID = 1;
	private static final BigDecimal AMOUNT=new BigDecimal(1000);
	private static final PaymentType TYPE= PaymentType.BOLETO;
	private static final PaymentStatus STATUS= PaymentStatus.APPROVED;
	
	private PaymentMapper paymentMapper = PaymentMapper.INSTANCE;
	
	@Test
	public void paymentToPaymentDTO() {
		Payment payment = Payment.builder()
				.id(ID)
				.amount(AMOUNT)
				.type(TYPE)
				.status(STATUS)
				.build();
		
		PaymentDTO paymentDTO = paymentMapper.paymentToPaymentDTO(payment);
		
		assertEquals(String.valueOf(ID), paymentDTO.getId());
		assertEquals(AMOUNT.toString(), paymentDTO.getAmount());
		assertEquals(TYPE.toString(), paymentDTO.getType());
		assertEquals(STATUS.toString(), paymentDTO.getStatus());
	}
	
	@Test
	public void paymentDTOToPayment() {
		PaymentDTO paymentDTO = PaymentDTO.builder()
				.id(String.valueOf(ID))
				.amount(AMOUNT.toString())
				.type(TYPE.toString())
				.status(STATUS.toString())
				.build();
		
		Payment payment = paymentMapper.paymentDTOToPayment(paymentDTO);
		
		assertEquals(ID, payment.getId());
		assertEquals(AMOUNT, payment.getAmount());
		assertEquals(TYPE, payment.getType());
		assertEquals(STATUS, payment.getStatus());
	}
}
