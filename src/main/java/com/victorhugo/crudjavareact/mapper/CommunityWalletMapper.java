package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.CommunityWalletDTO;
import com.victorhugo.crudjavareact.model.CommunityWallet;

public class CommunityWalletMapper {

    public static CommunityWalletDTO toDTO(CommunityWallet communityWallet){
        return CommunityWalletDTO.builder()
                .id(communityWallet.getId())
                .balance(communityWallet.getBalance())
                .debt(communityWallet.getDebt())
                .credit(communityWallet.getCredit())
                .availableBalance(communityWallet.getAvailableBalance())
                .userList(
                        communityWallet.getUserList().stream().map(UserMapper::toDTO).toList())
                .financialTransactionList(
                        communityWallet.getFinancialTransactionList().stream().map(FinancialTransactionMapper::toDTO).toList())
                .supportInf(
                        SupportInfMapper.toDTO(communityWallet.getSupportInf()))
                .build();
    }

    public static CommunityWallet toEntity(CommunityWalletDTO communityWalletDTO){
        return CommunityWallet.builder()
                .id(communityWalletDTO.getId())
                .balance(communityWalletDTO.getBalance())
                .debt(communityWalletDTO.getDebt())
                .credit(communityWalletDTO.getCredit())
                .availableBalance(communityWalletDTO.getAvailableBalance())
                .userList(
                        communityWalletDTO.getUserList().stream().map(UserMapper::toEntity).toList())
                .financialTransactionList(
                        communityWalletDTO.getFinancialTransactionList().stream().map(FinancialTransactionMapper::toEntity).toList())
                .supportInf(
                        SupportInfMapper.toEntity(communityWalletDTO.getSupportInf()))
                .build();
    }
}
