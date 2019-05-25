package com.payments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payments.domain.Payment;
import com.payments.dto.PaymentDTO;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Mapper
public interface PaymentMapper {

	public PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
	
	public PaymentDTO paymentToPaymentDTO(Payment payment);
	
	public Payment paymentDTOToPayment(PaymentDTO paymentDTO);
	
}