package org.example.wallet.service;

import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.CategoryDto;
import org.example.wallet.entity.Categories;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.repository.CategoryRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepos categoryRepos;

    public ApiResponse addCategory(CategoryDto categoryDto) {

        Categories categories = new Categories();
        categories.setCategoryName(categoryDto.getCategoryName());
        categories.setCategoriyDescription(categories.getCategoriyDescription());

        if (categoryDto.getParentId() != null) {
            Optional<Categories> parentCategory = categoryRepos.findById(categoryDto.getParentId());
            parentCategory.ifPresent(categories::setParentCategory);
        }

        categoryRepos.save(categories);
        return new ApiResponse("Added category successfully", true, categories);
    }

    public ApiResponse getAllCategory() {
        List<Categories> getAllCategory = categoryRepos.findAll();
        return new ApiResponse("All categories successfully", true, getAllCategory);
    }

    public ApiResponse getChildCategory(UUID parentId) {
        List<Categories> findChildCategories = categoryRepos.findAllById(parentId);
        return new ApiResponse("Child categories successfully", true, findChildCategories);
    }
}
