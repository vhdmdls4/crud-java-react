package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.CreateFinancialTransactionDTO;
import com.victorhugo.crudjavareact.DTO.FinancialTransactionDTO;
import com.victorhugo.crudjavareact.model.FinancialTransaction;


public class FinancialTransactionMapper {

    public static FinancialTransactionDTO toDTO(FinancialTransaction financialTransaction){
        return FinancialTransactionDTO.builder()
                .id(financialTransaction.getId())
                .description(financialTransaction.getDescription())
                .dateTime(financialTransaction.getDateTime())
                .sourceWallet(
                        WalletMapper.toDTO(financialTransaction.getSourceWallet()))
                .targetWallet(
                        WalletMapper.toDTO(financialTransaction.getTargetWallet()))
                .user(UserMapper.toDTO(financialTransaction.getUser()))
                .status(financialTransaction.getStatus())
                .financialTransactionType(financialTransaction.getFinancialTransactionType())
                .value(financialTransaction.getValue())
                .status(financialTransaction.getStatus())
                .build();
    }

    public static FinancialTransaction toEntity(FinancialTransactionDTO financialTransactionDTO){
        return FinancialTransaction.builder()
                .id(financialTransactionDTO.getId())
                .description(financialTransactionDTO.getDescription())
                .dateTime(financialTransactionDTO.getDateTime())
                .sourceWallet(
                        WalletMapper.toEntity(financialTransactionDTO.getSourceWallet()))
                .targetWallet(
                        WalletMapper.toEntity(financialTransactionDTO.getTargetWallet()))
                .user(UserMapper.toEntity(financialTransactionDTO.getUser()))
                .status(financialTransactionDTO.getStatus())
                .financialTransactionType(financialTransactionDTO.getFinancialTransactionType())
                .value(financialTransactionDTO.getValue())
                .status(financialTransactionDTO.getStatus())
                .build();
    }

    public static CreateFinancialTransactionDTO entityToCreateTransactionDTO(FinancialTransaction financialTransaction) {
        return CreateFinancialTransactionDTO.builder()
                .description(financialTransaction.getDescription())
                .dateTime(financialTransaction.getDateTime())
                .sourceWallet(WalletMapper.toDTO(financialTransaction.getSourceWallet()))
                .targetWallet(WalletMapper.toDTO(financialTransaction.getTargetWallet()))
                .user(UserMapper.toDTO(financialTransaction.getUser()))
                .status(financialTransaction.getStatus())
                .financialTransactionType(financialTransaction.getFinancialTransactionType())
                .value(financialTransaction.getValue())
                .build();
    }

    public static FinancialTransaction createTransactionDTOtoEntity(CreateFinancialTransactionDTO createTransactionDTO) {
        return FinancialTransaction.builder()
                .description(createTransactionDTO.getDescription())
                .dateTime(createTransactionDTO.getDateTime())
                .sourceWallet(WalletMapper.toEntity(createTransactionDTO.getSourceWallet()))
                .targetWallet(WalletMapper.toEntity(createTransactionDTO.getTargetWallet()))
                .user(UserMapper.toEntity(createTransactionDTO.getUser()))
                .status(createTransactionDTO.getStatus())
                .financialTransactionType(createTransactionDTO.getFinancialTransactionType())
                .value(createTransactionDTO.getValue())
                .build();
    }
}
