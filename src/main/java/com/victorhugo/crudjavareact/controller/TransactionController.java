package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.CreateFinancialTransactionDTO;
import com.victorhugo.crudjavareact.services.FinancialTransactionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class TransactionController {

    final FinancialTransactionServices financialTransactionServices;

    @PostMapping
    public ResponseEntity<CreateFinancialTransactionDTO> createTransaction(@RequestBody CreateFinancialTransactionDTO createFinancialTransactionDTO){
        CreateFinancialTransactionDTO createdFinancialTransactionDTO = financialTransactionServices.createFinancialTransaction(createFinancialTransactionDTO);
        return ResponseEntity.ok().body(createdFinancialTransactionDTO);
    }
}
