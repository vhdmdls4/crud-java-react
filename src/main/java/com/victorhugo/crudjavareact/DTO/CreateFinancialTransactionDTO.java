package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.FinancialTransactionStatus;
import com.victorhugo.crudjavareact.enums.FinancialTransactionType;
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
    private WalletDTO sourceWallet;
    private WalletDTO targetWallet;
    private UserDTO user;
    private FinancialTransactionStatus status;
    private FinancialTransactionType financialTransactionType;
}
