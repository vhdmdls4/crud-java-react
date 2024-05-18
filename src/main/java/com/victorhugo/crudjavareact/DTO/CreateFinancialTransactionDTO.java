package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.FinancialTransactionStatus;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.model.Wallet;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFinancialTransactionDTO {
    private BigDecimal value;
    private String description;
    private LocalDateTime dateTime;
    private Wallet sourceWallet;
    private Wallet targetWallet;
    private User user;
    private FinancialTransactionStatus status;
}
