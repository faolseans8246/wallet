package org.example.wallet.controller;


import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.CategoryDto;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryDto categoryDto) {
        ApiResponse apiResponse = categoryService.addCategory(categoryDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }


    @GetMapping("/takes")
    public ResponseEntity<ApiResponse> getCategories() {
        ApiResponse apiResponse = categoryService.getAllCategory();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }


    @GetMapping("/take/{childId}")
    public ResponseEntity<ApiResponse> getChildCategories(@PathVariable UUID childId) {
        ApiResponse apiResponse = categoryService.getChildCategory(childId);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
