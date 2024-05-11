package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.model.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
}
