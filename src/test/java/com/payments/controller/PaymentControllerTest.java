package com.payments.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.payments.controller.PaymentController;
import com.payments.controller.RestResponseEntityExceptionHandler;
import com.payments.domain.PaymentStatus;
import com.payments.dto.BoletoDTO;
import com.payments.dto.CardDTO;
import com.payments.dto.PaymentDTO;
import com.payments.exception.ResourceNotFoundException;
import com.payments.service.PaymentService;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class PaymentControllerTest extends AbstractRestControllerTest {

	private static final String FAKE_BOLETO_NUMBER = "1234 1234 1234 4321";

	@InjectMocks
	private PaymentController paymentController;
	
	@Mock
	private PaymentService paymentService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders
				.standaloneSetup(paymentController)
				.setControllerAdvice(new RestResponseEntityExceptionHandler())
				.build();
	}
	
	@Test
	public void checkPaymentStatus() throws Exception {
		PaymentDTO payment = PaymentDTO.builder()
			.id("1")
			.status(PaymentStatus.APPROVED.getDescription())
			.build();

		when(paymentService.findById(anyInt())).thenReturn(payment);

		mockMvc.perform(get(PaymentController.BASE_URL.concat("/1"))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", equalTo("1")))
				.andExpect(jsonPath("$.status", equalTo(PaymentStatus.APPROVED.getDescription())));
	}
	
	@Test
    public void checkPaymentStatusNotFound() throws Exception {
        when(paymentService.findById(anyInt())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(PaymentController.BASE_URL.concat("/1"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void createPaymentCreditCard() throws Exception {
		PaymentDTO payment = PaymentDTO.builder()
				.id("1")
				.type("Credit Card")
				.card(CardDTO.builder()
    					.number("5424606926573115")
    					.build())
				.build();
		
        when(paymentService.create(payment)).thenReturn(PaymentStatus.APPROVED.getDescription());

        mockMvc.perform(post(PaymentController.BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(payment)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", equalTo(PaymentStatus.APPROVED.getDescription())));
    }
	
	@Test
    public void createPaymentBoleto() throws Exception {
		PaymentDTO payment = PaymentDTO.builder()
				.id("1")
				.type("Boleto")
				.boleto(BoletoDTO.builder()
						.id("1")
						.number(FAKE_BOLETO_NUMBER)
						.build())
				.build();
		
        when(paymentService.create(payment)).thenReturn(FAKE_BOLETO_NUMBER);

        mockMvc.perform(post(PaymentController.BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(payment)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", equalTo(FAKE_BOLETO_NUMBER)));
    }
	
}
