package com.victorhugo.crudjavareact.model;

import com.victorhugo.crudjavareact.enums.PersonType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.StringUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//single table é a estratégia padrão, que cria uma única tabela para todas as classes filhas
//joined cria uma tabela para cada classe filha, e faz join com a tabela mãe
//table_per_class cria uma tabela para cada classe

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
