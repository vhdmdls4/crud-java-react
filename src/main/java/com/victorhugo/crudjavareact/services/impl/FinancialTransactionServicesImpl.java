package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateFinancialTransactionDTO;
import com.victorhugo.crudjavareact.DTO.FinancialTransactionDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.mapper.TransactionMapper;
import com.victorhugo.crudjavareact.model.FinancialTransaction;
import com.victorhugo.crudjavareact.repository.FinancialTransactionRepository;
import com.victorhugo.crudjavareact.services.FinancialTransactionServices;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinancialTransactionServicesImpl implements FinancialTransactionServices {

    private FinancialTransactionRepository financialTransactionRepository;

    @Override
    public CreateFinancialTransactionDTO createFinancialTransaction(CreateFinancialTransactionDTO createFinancialTransactionDTO) {
        FinancialTransaction financialTransactionPersisted = financialTransactionRepository.save(TransactionMapper.createTransactionDTOtoEntity(createFinancialTransactionDTO));
        return TransactionMapper.entityToCreateTransactionDTO(financialTransactionPersisted);
    }

}
