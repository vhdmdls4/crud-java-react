package com.victorhugo.crudjavareact.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO - implement UUID generation, mapping and etc for wallet and other entities
//    @Column(unique = true, updatable = false)
//    private UUID uuid;
    @NotBlank
    private BigDecimal balance;
    @NotBlank
    private BigDecimal availableBalance;
    //TODO - think about the necessity of debt and credit
    private BigDecimal debt;
    private BigDecimal credit;

    @OneToOne(mappedBy = "wallet")
    private User user;

    //I should use eager fetch, shouldn't?
    @OneToMany
    @ToString.Exclude
    private List<FinancialTransaction> financialTransactionList;

    private SupportInf supportInf;

}
