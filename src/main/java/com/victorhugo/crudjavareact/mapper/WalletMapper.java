package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.WalletDTO;
import com.victorhugo.crudjavareact.model.Wallet;

public class WalletMapper {
    public static WalletDTO toDTO(Wallet wallet) {
        return WalletDTO.builder()
                .id(wallet.getId())
                .balance(wallet.getBalance())
                .debt(wallet.getDebt())
                .credit(wallet.getCredit())
                .financialTransactionList(
                        wallet.getFinancialTransactionList().stream().map(
                                TransactionMapper::toDTO).toList())
                .supportInf(
                        SupportInfMapper.toDTO(wallet.getSupportInf()))
                .availableBalance(wallet.getAvailableBalance())
                .build();
    }

    public static Wallet toEntity(WalletDTO walletDTO) {
        return Wallet.builder()
                .id(walletDTO.getId())
                .balance(walletDTO.getBalance())
                .debt(walletDTO.getDebt())
                .credit(walletDTO.getCredit())
                .financialTransactionList(
                        walletDTO.getFinancialTransactionList().stream().map(
                                TransactionMapper::toEntity).toList())
                .supportInf(
                        SupportInfMapper.toEntity(walletDTO.getSupportInf()))
                .availableBalance(walletDTO.getAvailableBalance())
                .build();
    }
}
