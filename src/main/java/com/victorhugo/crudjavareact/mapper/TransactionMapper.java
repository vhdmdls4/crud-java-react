package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.CreateFinancialTransactionDTO;
import com.victorhugo.crudjavareact.DTO.FinancialTransactionDTO;
import com.victorhugo.crudjavareact.model.FinancialTransaction;
import lombok.*;


public class TransactionMapper {
    public static FinancialTransactionDTO toDTO(FinancialTransaction financialTransaction){
        return FinancialTransactionDTO.builder()
                .id(financialTransaction.getId())
                .value(financialTransaction.getValue())
                .user(financialTransaction.getUser())
                .sourceWallet(financialTransaction.getSourceWallet())
                .targetWallet(financialTransaction.getTargetWallet())
                .description(financialTransaction.getDescription())
                .dateTime(financialTransaction.getDateTime())
                .status(financialTransaction.getStatus())
                .build();
    }

    public static FinancialTransaction toEntity(FinancialTransactionDTO financialTransactionDTO){
        return FinancialTransaction.builder()
                .value(financialTransactionDTO.getValue())
                .user(financialTransactionDTO.getUser())
                .sourceWallet(financialTransactionDTO.getSourceWallet())
                .targetWallet(financialTransactionDTO.getTargetWallet())
                .description(financialTransactionDTO.getDescription())
                .dateTime(financialTransactionDTO.getDateTime())
                .status(financialTransactionDTO.getStatus())
                .build();
    }

    public static CreateFinancialTransactionDTO entityToCreateTransactionDTO(FinancialTransaction createFinancialTransactionDTO){
        return CreateFinancialTransactionDTO.builder()
                .build();
    }

    public static FinancialTransaction createTransactionDTOtoEntity(CreateFinancialTransactionDTO createTransactionDTO){
        return FinancialTransaction.builder()
                .build();
    }
}
