package com.houarizegai.springbatchapp.repository;

import com.houarizegai.springbatchapp.domain.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
}
