package com.victorhugo.crudjavareact.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "legal_persons")
@DiscriminatorValue("LEGAL")
public class LegalPerson extends Person{
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable = false)
//private Long id;
    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    private String cnpj;
}
