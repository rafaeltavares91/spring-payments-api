package com.payments.mapper;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.payments.domain.Card;
import com.payments.dto.CardDTO;
import com.payments.mapper.CardMapper;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class CardMapperTest {

	private static final Integer ID = 1;
	private static final String NUMBER = "014441231232442";
	private static final String HOLDER_NAME="Rafael de Souza Pires Tavares";
	private static final Date EXPIRATION_DATE=new Date();
	private static final String CVV="513";
	
	private CardMapper cardMapper = CardMapper.INSTANCE;
	
	@Test
	public void cardToCardDTO() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Card card = Card.builder()
				.id(ID)
				.holderName(HOLDER_NAME)
				.number(NUMBER)
				.cvv(CVV)
				.expirationDate(EXPIRATION_DATE)
				.build();
		
		CardDTO cardDTO = cardMapper.cardToCardDTO(card);
		
		assertEquals(ID, cardDTO.getId());
		assertEquals(HOLDER_NAME, cardDTO.getHolderName());
		assertEquals(NUMBER, cardDTO.getNumber());
		assertEquals(CVV, cardDTO.getCvv());
		assertEquals(dateFormat.format(EXPIRATION_DATE), cardDTO.getExpirationDate());
	}
	
	@Test
	public void cardDTOToCard() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		CardDTO cardDTO = CardDTO.builder()
				.id(ID)
				.holderName(HOLDER_NAME)
				.number(NUMBER)
				.cvv(CVV)
				.expirationDate(dateFormat.format(EXPIRATION_DATE))
				.build();
		
		Card card = cardMapper.cardDTOToCard(cardDTO);
		
		assertEquals(ID, card.getId());
		assertEquals(HOLDER_NAME, card.getHolderName());
		assertEquals(NUMBER, card.getNumber());
		assertEquals(CVV, card.getCvv());
		assertEquals(dateFormat.format(EXPIRATION_DATE), dateFormat.format(card.getExpirationDate()));
	}
	
}