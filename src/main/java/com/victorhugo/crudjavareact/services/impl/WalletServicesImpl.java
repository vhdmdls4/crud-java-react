package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateWalletDTO;
import com.victorhugo.crudjavareact.DTO.WalletDTO;
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
        userServices.checkIfUserExists(createWalletDTO.getUser().getUsername(), createWalletDTO.getUser().getEmail());
        Wallet createdWallet = walletRepository.save(WalletMapper.createWalletDTOtoEntity(createWalletDTO));
        return WalletMapper.toDTO(createdWallet);
    }
}
