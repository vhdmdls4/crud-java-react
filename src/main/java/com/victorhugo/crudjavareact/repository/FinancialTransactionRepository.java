package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.model.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
}
