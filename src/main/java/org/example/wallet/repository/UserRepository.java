package org.example.wallet.repository;

import org.example.wallet.entity.UserNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserNotes, UUID>, CrudRepository<UserNotes, UUID> {

    Optional<UserNotes> findByFirstName(String firstName);
    Optional<UserNotes> findByLastName(String lastName);
    Optional<UserNotes> findByFirstNameAndLastName(String firstName, String lastName);
}
