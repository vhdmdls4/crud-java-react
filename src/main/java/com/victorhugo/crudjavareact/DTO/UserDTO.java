package com.victorhugo.crudjavareact.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String hashPassword;
    private LocalDate lastSession;
    private WalletDTO wallet;
    private List<CommunityWalletDTO> communityWalletList;
    private boolean deleted = Boolean.FALSE;
}
