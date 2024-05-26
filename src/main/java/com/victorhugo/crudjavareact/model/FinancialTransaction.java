package com.victorhugo.crudjavareact.model;

import com.victorhugo.crudjavareact.enums.FinancialTransactionStatus;
import com.victorhugo.crudjavareact.enums.FinancialTransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
// ISSUE - algo de errado com o requiredArgsConstructor nesse contexto de entidade classe
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_transactions")
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime dateTime;
    //when a ToOne anotation is interpreted, java deal with it like a eager fetch, cause it's just a value
    //but when the anotation is ToMany, it's lazy fetch, it'll wait till need
    @ManyToOne
    @JoinColumn(name = "source_wallet_id")
    private Wallet sourceWallet;

    @ManyToOne
    @JoinColumn(name = "target_wallet_id")
    private Wallet targetWallet;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private FinancialTransactionStatus status;

    @Enumerated(EnumType.STRING)
    private FinancialTransactionType financialTransactionType;

    private BigDecimal value;

}
