package com.victorhugo.crudjavareact.model;

import com.victorhugo.crudjavareact.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

//é possível fazer namedQueries via annotation mas não é recomendado
//é melhor fazer via xml
//@NamedQueries({
//        @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
//        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
//        @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
//})
// também é possível fazer namedNativeQueries via annotation mas não é recomendado pelo mesmo motivo
//@NamedNativeQueries({
//        @NamedNativeQuery(name = "User.findByName", query = "SELECT * FROM users WHERE name = :name", resultClass = User.class),
//        @NamedNativeQuery(name = "User.findByEmail", query = "SELECT * FROM users WHERE email = :email", resultClass = User.class),
//        @NamedNativeQuery(name = "User.findByUsername", query = "SELECT * FROM users WHERE username = :username", resultClass = User.class)
//})

// faça uma classe que faça namedQueries e namedNativeQueries


@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank
    @NotEmpty
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank
    @NotEmpty
    private String username;

    private String hashPassword;

    private LocalDate lastSession;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private boolean deleted = Boolean.FALSE;

//    @JoinTable(name = "user_community_wallet",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "community_wallet_id"))
    @ManyToMany
    private List<CommunityWallet> communityWalletList;

    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return switch (role) {
            case ADMIN -> List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
            case SUPPORT -> List.of(new SimpleGrantedAuthority("ROLE_SUPPORT"));
            default -> List.of(new SimpleGrantedAuthority("ROLE_USER"));
        };
    }

    @Override
    public String getPassword() {
        return hashPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
