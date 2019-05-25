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
public class BuyerDTO {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpf;
	
}