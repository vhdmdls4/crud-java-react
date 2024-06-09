package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.CreateWalletDTO;
import com.victorhugo.crudjavareact.DTO.WalletDTO;
import com.victorhugo.crudjavareact.model.Wallet;

public class WalletMapper {
    public static WalletDTO toDTO(Wallet wallet) {
        return WalletDTO.builder()
                .id(wallet.getId())
                .balance(wallet.getBalance())
                .debt(wallet.getDebt())
                .credit(wallet.getCredit())
                .user(UserMapper.toDTO(wallet.getUser()))
                .financialTransactionList(
                        wallet.getFinancialTransactionList().stream().map(
                                FinancialTransactionMapper::toDTO).toList())
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
                .user(UserMapper.toEntity(walletDTO.getUser()))
                .financialTransactionList(
                        walletDTO.getFinancialTransactionList().stream().map(
                                FinancialTransactionMapper::toEntity).toList())
                .supportInf(
                        SupportInfMapper.toEntity(walletDTO.getSupportInf()))
                .availableBalance(walletDTO.getAvailableBalance())
                .build();
    }

    public static Wallet createWalletDTOtoEntity(CreateWalletDTO createWalletDTO) {
        return Wallet.builder()
                .balance(createWalletDTO.getBalance())
                .debt(createWalletDTO.getDebt())
                .credit(createWalletDTO.getCredit())
                .user(UserMapper.toEntity(createWalletDTO.getUser()))
                .availableBalance(createWalletDTO.getAvailableBalance())
                .build();
    }

    public static CreateWalletDTO entityToCreateWalletDTO(Wallet wallet) {
        return CreateWalletDTO.builder()
                .balance(wallet.getBalance())
                .debt(wallet.getDebt())
                .credit(wallet.getCredit())
                .user(UserMapper.toDTO(wallet.getUser()))
                .availableBalance(wallet.getAvailableBalance())
                .build();
    }
}
