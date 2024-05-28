package com.victorhugo.crudjavareact.model;

import com.victorhugo.crudjavareact.enums.SupportType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SupportInf {
    private Long supportId;
    private SupportType supportType;
}
