package com.payments.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.payments.domain.Boleto;
import com.payments.domain.Payment;
import com.payments.dto.CardDTO;
import com.payments.dto.PaymentDTO;
import com.payments.exception.ResourceNotFoundException;
import com.payments.mapper.PaymentMapper;
import com.payments.repository.PaymentRepository;
import com.payments.service.PaymentService;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class PaymentServiceTest {

	private static final String VALID_CREDIT_CARD_NUMBER = "5424606926573115";
	
	private static final String INVALID_CREDIT_CARD_NUMBER = "12345";
	
    private PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    private PaymentService paymentService;
    
    @Mock
    private PaymentRepository paymentRepository;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        paymentService = new PaymentService(paymentMapper, paymentRepository);
    }
    
	@Test
    public void findPaymentById() {
        Payment payment1 = Payment.builder().id(1).build();

        when(paymentRepository.findById(anyInt())).thenReturn(Optional.ofNullable(payment1));

        PaymentDTO paymentDTO = paymentService.findById(99);

        assertEquals("1", paymentDTO.getId());
        verify(paymentRepository, times(1)).findById(any());
    }
	
	@Test(expected = ResourceNotFoundException.class)
    public void findByIdThrowsException()  {
        when(paymentRepository.findById(anyInt())).thenThrow(ResourceNotFoundException.class);

        PaymentDTO paymentDTO = paymentService.findById(1);

        assertEquals("1", paymentDTO.getId());
        verify(paymentRepository, times(1)).findById(any());
    }
	
	@Test
    public void createPaymentTypeCreditCardApproved() throws Exception {
    	String expectedResult = "Approved";
    	PaymentDTO paymentDTO = PaymentDTO.builder()
    			.id("1")
    			.type("CREDIT_CARD")
    			.card(CardDTO.builder()
    					.number(VALID_CREDIT_CARD_NUMBER)
    					.build())
    			.build();

        String result = paymentService.create(paymentDTO);

        assertEquals(expectedResult, result);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }
	
    @Test
    public void createPaymentTypeCreditCardDenied() throws Exception {
    	String expectedResult = "Denied";
    	PaymentDTO paymentDTO = PaymentDTO.builder()
    			.id("1")
    			.type("CREDIT_CARD")
    			.card(CardDTO.builder()
    					.number(INVALID_CREDIT_CARD_NUMBER)
    					.build())
    			.build();

        String result = paymentService.create(paymentDTO);

        assertEquals(expectedResult, result);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }
    
    @Test
    public void createPaymentTypeBoleto() throws Exception {
    	PaymentDTO paymentDTO = PaymentDTO.builder()
				.id("1")
				.type("BOLETO")
				.build();

        String result = paymentService.create(paymentDTO);

        assertEquals(Boleto.GENERATED_RESULT_NUMBER, result);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }
	
}
