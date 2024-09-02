package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateFinancialTransactionDTO;
import com.victorhugo.crudjavareact.mapper.FinancialTransactionMapper;
import com.victorhugo.crudjavareact.model.FinancialTransaction;
import com.victorhugo.crudjavareact.repository.FinancialTransactionRepository;
import com.victorhugo.crudjavareact.services.FinancialTransactionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//TODO - implements a idempotency check in the createFinancialTransaction method

@Service
@RequiredArgsConstructor
public class FinancialTransactionServicesImpl implements FinancialTransactionServices {

    private final FinancialTransactionRepository financialTransactionRepository;

    @Override
    public CreateFinancialTransactionDTO createFinancialTransaction(CreateFinancialTransactionDTO createFinancialTransactionDTO) {
        FinancialTransaction financialTransactionPersisted = financialTransactionRepository.save(FinancialTransactionMapper.createTransactionDTOtoEntity(createFinancialTransactionDTO));
        return FinancialTransactionMapper.entityToCreateTransactionDTO(financialTransactionPersisted);
    }

}
