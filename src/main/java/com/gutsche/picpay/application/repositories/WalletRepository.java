package com.gutsche.picpay.application.repositories;

import com.gutsche.picpay.domain.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
  Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
