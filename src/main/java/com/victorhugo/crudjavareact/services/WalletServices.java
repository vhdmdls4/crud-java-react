package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.DTO.CreateWalletDTO;
import com.victorhugo.crudjavareact.DTO.WalletDTO;
import org.springframework.stereotype.Service;

@Service
public interface WalletServices {
    WalletDTO createWallet(CreateWalletDTO createWalletDTO);
}
