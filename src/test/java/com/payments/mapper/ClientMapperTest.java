package com.payments.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.payments.domain.Client;
import com.payments.dto.ClientDTO;
import com.payments.mapper.ClientMapper;

/**
 * 
 * @author Rafael Tavares
 *
 */
public class ClientMapperTest {

	private static final Integer ID = 1;
	
	private ClientMapper clientMapper = ClientMapper.INSTANCE;
	
	@Test
	public void clientToClientDTO() {
		Client client = Client.builder()
				.id(ID)
				.build();
		
		ClientDTO clientDTO = clientMapper.clientToClientDTO(client);
		
		assertEquals(ID, clientDTO.getId());
	}
	
	@Test
	public void clientDTOToClient() {
		ClientDTO clientDTO = ClientDTO.builder()
				.id(ID)
				.build();
		
		Client client = clientMapper.clientDTOToClient(clientDTO);
		
		assertEquals(ID, client.getId());
	}
}