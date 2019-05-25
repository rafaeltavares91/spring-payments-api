package com.payments.service;

import org.springframework.stereotype.Service;

import com.payments.domain.Payment;
import com.payments.dto.PaymentDTO;
import com.payments.exception.ResourceNotFoundException;
import com.payments.mapper.PaymentMapper;
import com.payments.processor.PaymentProcessorFactory;
import com.payments.repository.PaymentRepository;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Service
public class PaymentService {
	
	private final PaymentMapper paymentMapper;
	private final PaymentRepository paymentRepository;
	
	public PaymentService(PaymentMapper paymentMapper, PaymentRepository paymentRepository) {
		this.paymentMapper = paymentMapper;
		this.paymentRepository = paymentRepository;
	}
	
	public PaymentDTO findById(Integer id) {
		return paymentMapper.paymentToPaymentDTO(paymentRepository
				.findById(id)
				.orElseThrow(ResourceNotFoundException::new));
	}

	public String create(PaymentDTO paymentDTO) {
		Payment payment = paymentMapper.paymentDTOToPayment(paymentDTO);
		String result = PaymentProcessorFactory
				.getProcessor(payment.getType())
				.process(payment);
		paymentRepository.save(payment);
		return result;
	}

}