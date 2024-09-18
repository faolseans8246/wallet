package org.example.wallet.repository;

import org.example.wallet.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TransactionRepos extends JpaRepository<Transactions, UUID> {

}
