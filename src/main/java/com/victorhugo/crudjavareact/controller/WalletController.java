package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.CreateWalletDTO;
import com.victorhugo.crudjavareact.DTO.WalletDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.services.WalletServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {
    final WalletServices walletServices;
    public ResponseEntity<WalletDTO> createWallet(@Valid @RequestBody CreateWalletDTO createWalletDTO){
        try {
            WalletDTO walletCreated = walletServices.createWallet(createWalletDTO);
            return ResponseEntity.ok().body(walletCreated);
        } catch (GenericApplicationException exception){
            return ResponseEntity.badRequest().build();
        }
    }
}
