package com.payments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payments.domain.Buyer;
import com.payments.dto.BuyerDTO;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Mapper
public interface BuyerMapper {

	public BuyerMapper INSTANCE = Mappers.getMapper(BuyerMapper.class);
	
	public BuyerDTO buyerToBuyerDTO(Buyer buyer);
	
	public Buyer buyerDTOToBuyer(BuyerDTO buyerDTO);
	
}