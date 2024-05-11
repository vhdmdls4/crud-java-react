package com.victorhugo.crudjavareact.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String userName;
    private String hashPassword;
    private LocalDate lastSession;
    @OneToOne
    private Wallet wallet;
    @OneToMany
    private List<FinancialTransaction> transactionList;
}
