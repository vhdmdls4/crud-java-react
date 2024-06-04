package com.victorhugo.crudjavareact.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "natural_persons")
@DiscriminatorValue("NATURAL")
public class NaturalPerson extends Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private Long id;
    @NotBlank
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String cpf;
}
