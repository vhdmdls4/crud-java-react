package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.FinancialTransactionStatus;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.model.Wallet;
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
    private Wallet sourceWallet;
    private Wallet targetWallet;
    private User user;
    private FinancialTransactionStatus status;

}
