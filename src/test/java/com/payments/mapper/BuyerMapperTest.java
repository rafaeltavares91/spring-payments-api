package com.payments.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.payments.domain.Buyer;
import com.payments.dto.BuyerDTO;
import com.payments.mapper.BuyerMapper;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class BuyerMapperTest {

	private static final Integer ID = 1;
	private static final String NAME = "Killua";
	private static final String EMAIL = "teste@gmail.com";
	private static final String CPF = "09848191178";
	
	private BuyerMapper buyerMapper = BuyerMapper.INSTANCE;
	
	@Test
	public void buyerToBuyerDTO() {
		Buyer buyer = Buyer.builder()
				.id(ID)
				.name(NAME)
				.email(EMAIL)
				.cpf(CPF)
				.build();
		
		BuyerDTO buyerDTO = buyerMapper.buyerToBuyerDTO(buyer);
		
		assertEquals(ID, buyerDTO.getId());
		assertEquals(NAME, buyerDTO.getName());
		assertEquals(EMAIL, buyerDTO.getEmail());
		assertEquals(CPF, buyerDTO.getCpf());
	}
	
	@Test
	public void buyerDTOToBuyer() {
		BuyerDTO buyerDTO=BuyerDTO.builder()
				.id(ID)
				.name(NAME)
				.email(EMAIL)
				.cpf(CPF)
				.build();
		
		Buyer buyer = buyerMapper.buyerDTOToBuyer(buyerDTO);
		
		assertEquals(ID, buyer.getId());
		assertEquals(NAME, buyer.getName());
		assertEquals(EMAIL, buyer.getEmail());
		assertEquals(CPF, buyer.getCpf());
	}
}