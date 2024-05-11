package com.victorhugo.crudjavareact.dto;

import com.victorhugo.crudjavareact.model.FinancialTransaction;
import com.victorhugo.crudjavareact.model.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String hashPassword;
    private LocalDate lastSession;
    private Wallet wallet;
    private List<FinancialTransaction> transactionList;
}
