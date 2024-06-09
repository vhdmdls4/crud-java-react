package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.SupportType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupportInfDTO implements Serializable {
    private Long supportId;
    private SupportType supportType;
}
