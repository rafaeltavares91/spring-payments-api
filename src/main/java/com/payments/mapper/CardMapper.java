package com.payments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payments.domain.Card;
import com.payments.dto.CardDTO;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Mapper
public interface CardMapper {

	public CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
	
	public CardDTO cardToCardDTO(Card card);
	
	public Card cardDTOToCard(CardDTO cardDTO);
	
}