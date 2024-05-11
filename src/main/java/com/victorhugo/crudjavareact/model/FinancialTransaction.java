package com.victorhugo.crudjavareact.model;

import com.victorhugo.crudjavareact.enums.FinancialTransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class FinancialTransaction {
    private BigDecimal value;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "source_wallet_id")
    private Wallet sourceWallet;
    @ManyToOne
    private Wallet targetWallet;
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private FinancialTransactionStatus status;
}
