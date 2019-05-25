package com.payments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.payments.domain.Client;
import com.payments.dto.ClientDTO;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Mapper
public interface ClientMapper {

	public ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
	
	public ClientDTO clientToClientDTO(Client client);
	
	public Client clientDTOToClient(ClientDTO clientDTO);
	
}