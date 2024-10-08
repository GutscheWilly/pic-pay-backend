package com.gutsche.picpay.application.repositories;

import com.gutsche.picpay.domain.entities.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {

}
