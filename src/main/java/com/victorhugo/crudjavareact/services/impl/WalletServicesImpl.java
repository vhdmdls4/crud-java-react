package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateWalletDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.DTO.WalletDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.mapper.WalletMapper;
import com.victorhugo.crudjavareact.model.Wallet;
import com.victorhugo.crudjavareact.repository.WalletRepository;
import com.victorhugo.crudjavareact.services.UserServices;
import com.victorhugo.crudjavareact.services.WalletServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServicesImpl implements WalletServices {
    final WalletRepository walletRepository;
    final UserServices userServices;
    @Override
    public WalletDTO createWallet(CreateWalletDTO createWalletDTO) {
        UserDTO userFound = userServices.findUserById(createWalletDTO.getUser().getId());
        validateIfUserHasWallet(userFound.getId());

        Wallet createdWallet = walletRepository.save(WalletMapper.createWalletDTOtoEntity(createWalletDTO));
        return WalletMapper.toDTO(createdWallet);
    }

    @Override
    public WalletDTO findWalletById(Long id) {
        Wallet walletFound = walletRepository.findById(id).orElseThrow(() -> new GenericApplicationException("Wallet not found"));
        return WalletMapper.toDTO(walletFound);
    }

    @Override
    public WalletDTO findWalletByUserId(Long userId) {
        Wallet walletFound = walletRepository.findByUser_Id(userId).
                orElseThrow(() -> new GenericApplicationException("Wallet not found"));
        return WalletMapper.toDTO(walletFound);
    }

    public void validateIfUserHasWallet(Long userId){
        UserDTO userFound = userServices.findUserById(userId);
        if(userFound.getWallet() != null) {
            throw new GenericApplicationException("User already has a wallet");
        };
    }

    public void validateIfWalletExists(Long walletId){
        walletRepository.findById(walletId).orElseThrow(() -> new GenericApplicationException("Wallet not found"));
    }

    public Boolean checkIfWalletExists(Long walletId){
        return walletRepository.existsById(walletId);
    }

}
