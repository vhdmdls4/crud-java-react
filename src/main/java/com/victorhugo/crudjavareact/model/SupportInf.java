package com.victorhugo.crudjavareact.model;

import com.victorhugo.crudjavareact.enums.SupportType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportInf {
    private Long supportId;
    private SupportType supportType;
}
