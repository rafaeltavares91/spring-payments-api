package com.payments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payments.domain.Boleto;
import com.payments.dto.BoletoDTO;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Mapper
public interface BoletoMapper {

	public BoletoMapper INSTANCE = Mappers.getMapper(BoletoMapper.class);
	
	public BoletoDTO boletoToBoletoDTO(Boleto boleto);
	
	public Boleto boletoDTOToBoleto(BoletoDTO boletoDTO);
	
}