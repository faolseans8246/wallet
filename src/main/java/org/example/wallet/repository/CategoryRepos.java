package org.example.wallet.repository;

import org.example.wallet.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepos extends JpaRepository<Categories, UUID> {

    List<Categories> findAllById(UUID parentId);
}
