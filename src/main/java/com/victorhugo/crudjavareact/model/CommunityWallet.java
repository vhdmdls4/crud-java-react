package com.victorhugo.crudjavareact.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityWallet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private BigDecimal debt;
    private BigDecimal credit;
    private BigDecimal availableBalance;

    @ManyToMany(mappedBy = "communityWalletList")
    private List<User> userList;
    @OneToMany
    private List<FinancialTransaction> financialTransactionList;

    private SupportInf supportInf;
}
