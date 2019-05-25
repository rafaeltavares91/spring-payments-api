package com.payments.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

	private String id;
	
	private String amount;
	
	private String type;

	private String status;
	
	private ClientDTO client;

	private BuyerDTO buyer;

	private CardDTO card;
	
	private BoletoDTO boleto;

}