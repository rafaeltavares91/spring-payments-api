package com.payments.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.payments.domain.Boleto;
import com.payments.dto.BoletoDTO;
import com.payments.mapper.BoletoMapper;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class BoletoMapperTest {

	private static final Integer ID = 1;
	private static final String NUMBER = "014441231232442";
	
	private BoletoMapper boletoMapper = BoletoMapper.INSTANCE;
	
	@Test
	public void boletoToBoletoDTO() {
		Boleto boleto = Boleto.builder()
				.id(ID)
				.number(NUMBER)
				.build();
		
		BoletoDTO boletoDTO = boletoMapper.boletoToBoletoDTO(boleto);
		
		assertEquals(String.valueOf(ID), boletoDTO.getId());
		assertEquals(NUMBER, boletoDTO.getNumber());
	}
	
	@Test
	public void boletoDTOToBoleto() {
		BoletoDTO boletoDTO = BoletoDTO.builder()
				.id(String.valueOf(ID))
				.number(NUMBER)
				.build();
		
		Boleto boleto = boletoMapper.boletoDTOToBoleto(boletoDTO);
		
		assertEquals(ID, boleto.getId());
		assertEquals(NUMBER, boleto.getNumber());
	}
}