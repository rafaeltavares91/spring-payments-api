package com.payments.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Min(value = 1)
	private BigDecimal amount;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentType type;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	@Valid
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@Valid
	@ManyToOne
	@JoinColumn(name = "buyer_id", nullable = false)
	private Buyer buyer;

	@Valid
	@ManyToOne
	@JoinColumn(name = "card_id", nullable = true)
	private Card card;
	
	@Valid
	@ManyToOne
	@JoinColumn(name = "boleto_id", nullable = true)
	private Boleto boleto;
	
}