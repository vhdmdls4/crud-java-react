package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.SupportInfDTO;
import com.victorhugo.crudjavareact.model.SupportInf;

public class SupportInfMapper {
    public static SupportInfDTO toDTO(SupportInf supportInf){
        return SupportInfDTO.builder()
                .supportId(supportInf.getSupportId())
                .supportType(supportInf.getSupportType())
                .build();
    }
    public static SupportInf toEntity(SupportInfDTO supportInfDto){
        return SupportInf.builder()
                .supportId(supportInfDto.getSupportId())
                .supportType(supportInfDto.getSupportType())
                .build();
    }
}
