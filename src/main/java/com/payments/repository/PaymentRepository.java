package com.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.domain.Payment;

/**
 * 
 * @author Rafael Tavares
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}