package org.example.wallet.repository;

import org.example.wallet.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RegistrationRepos extends JpaRepository<Registration, UUID>, CrudRepository<Registration, UUID> {

    Optional<Registration> findByUsername(String username);
    Optional<Registration> findByEmail(String email);
}
