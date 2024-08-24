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
    /*
    *
    * Front-end request example
    * const url = "http://localhost:8080/test-multi";
    const formData = new FormData();

    // Assuming `file` is an array of files
    const listaFiles = Array.from(file);

    listaFiles.forEach((file, index) => {
      formData.append(`listaFilhos[${index}].multipartFile`, file);
      formData.append(`listaFilhos[${index}].name`, file.name);
    });

    const config = {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    };

    axios.post(url, formData, config).then((response) => {
      console.log(response.data);
    });
    *
    * */

    @GetMapping
    public ResponseEntity<?> handleGetTest(){
        return ResponseEntity.ok().build();
    }
}
