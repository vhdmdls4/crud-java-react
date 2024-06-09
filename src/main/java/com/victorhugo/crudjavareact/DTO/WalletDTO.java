package com.victorhugo.crudjavareact.DTO;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletDTO implements Serializable {
    private Long id;
    private BigDecimal balance;
    private BigDecimal debt;
    private BigDecimal credit;
    private BigDecimal availableBalance;
    private List<FinancialTransactionDTO> financialTransactionList;
    private SupportInfDTO supportInf;
}
