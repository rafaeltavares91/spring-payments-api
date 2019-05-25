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
public class CardDTO {

	private Integer id;
	
	private String holderName;
	
	private String number;
	
	private String expirationDate;
	
	private String cvv;
	
}