package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
