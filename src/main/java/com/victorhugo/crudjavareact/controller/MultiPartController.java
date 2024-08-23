package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.MultiPartDTOFather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-multi")
public class MultiPartController {
    @PostMapping
    public ResponseEntity<?> handleMultiPartRequest(@RequestBody MultiPartDTOFather listaDTORecebido){
        return ResponseEntity.ok("Ok");
    }

    @GetMapping
    public ResponseEntity<?> handleGetTest(){
        return ResponseEntity.ok().build();
    }
}
