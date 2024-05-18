package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.services.TransactionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class TransactionController {

    final TransactionServices transactionServices;

}
