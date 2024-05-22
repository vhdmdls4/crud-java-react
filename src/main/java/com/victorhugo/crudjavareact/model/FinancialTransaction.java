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
    @JoinColumn(name = "target_wallet_id")
    private Wallet targetWallet;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private FinancialTransactionStatus status;

    @Enumerated(EnumType.STRING)
    private FinancialTransactionType financialTransactionType;

    //generated by ide
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        FinancialTransaction that = (FinancialTransaction) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
