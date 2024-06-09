package com.victorhugo.crudjavareact.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityWalletDTO {
    private Long id;
    private BigDecimal balance;
    private BigDecimal debt;
    private BigDecimal credit;
    private BigDecimal availableBalance;
    private List<UserDTO> userList;
    private List<FinancialTransactionDTO> financialTransactionList;
    private SupportInfDTO supportInf;
}
