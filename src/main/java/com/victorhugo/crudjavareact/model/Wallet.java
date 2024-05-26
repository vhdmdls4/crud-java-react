package com.victorhugo.crudjavareact.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
    @Column(nullable = false)
    private Long id;
    private BigDecimal balance;
    private BigDecimal debt;
    private BigDecimal credit;
    private BigDecimal availableBalance;

    @OneToOne(mappedBy = "wallet")
    private User user;
    //I should use eager fetch, shouldn't?
    @OneToMany
    private List<FinancialTransaction> financialTransactionList;

    private SupportInf supportInf;

}
