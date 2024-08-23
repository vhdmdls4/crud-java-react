package com.victorhugo.crudjavareact.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultiPartDTOChild {
    private String name;
    private MultipartFile multipartFile;
}
