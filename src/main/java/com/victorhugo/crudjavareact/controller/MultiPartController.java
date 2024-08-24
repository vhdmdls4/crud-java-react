package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.MultiPartDTOChild;
import com.victorhugo.crudjavareact.DTO.MultiPartDTOFather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test-multi")
public class MultiPartController {
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> handleMultiPartRequest(@ModelAttribute MultiPartDTOFather listaDTORecebido){
        listaDTORecebido.getListaFilhos().forEach(child -> {
            MultipartFile file = child.getMultipartFile();
            try {
                String content = new BufferedReader(new InputStreamReader(file.getInputStream()))
                        .lines().collect(Collectors.joining("\n"));
                System.out.println("Nome do arquivo: " + file.getOriginalFilename());
                System.out.println("Conteúdo do arquivo:\n" + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return ResponseEntity.ok("Arquivos processados com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> handleGetTest(){
        return ResponseEntity.ok().build();
    }
}
