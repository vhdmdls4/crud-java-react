package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.DTO.CreateFinancialTransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface FinancialTransactionServices {
    public CreateFinancialTransactionDTO createFinancialTransaction(CreateFinancialTransactionDTO createFinancialTransactionDTO);
}
