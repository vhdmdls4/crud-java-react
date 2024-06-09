package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.FinancialTransactionStatus;
import com.victorhugo.crudjavareact.enums.FinancialTransactionType;
import com.victorhugo.crudjavareact.model.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FinancialTransactionDTO {
    private BigDecimal value;
    private Long id;
    private String description;
    private LocalDateTime dateTime;
    private WalletDTO sourceWallet;
    private WalletDTO targetWallet;
    private UserDTO user;
    private FinancialTransactionStatus status;
    private FinancialTransactionType financialTransactionType;

}
