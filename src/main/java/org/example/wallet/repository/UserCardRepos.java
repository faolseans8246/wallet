package org.example.wallet.repository;

import org.example.wallet.entity.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserCardRepos extends JpaRepository<UserCard, UUID> {

    List<UserCard> findAllByUserId(UUID userId);

    Optional<UserCard> findById(UUID cardId);
}
