package com.payments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payments.dto.PaymentDTO;
import com.payments.service.PaymentService;

/**
 * 
 * @author Rafael Tavares
 *
 */
@RestController
@RequestMapping(PaymentController.BASE_URL)
public class PaymentController {

	public static final String BASE_URL = "/payments";
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PaymentDTO checkPaymentStatus(@PathVariable("id") Integer id) {
		return paymentService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public String createPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.create(paymentDTO);
    }
	
}