package org.example.wallet.controller;


import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.UserCardDto;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.service.UserCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card")
public class UserCardController {

    private final UserCardService userCardService;

    @PostMapping("/addition/{id}")
    public ResponseEntity<ApiResponse> addCard(@PathVariable UUID id, @RequestBody UserCardDto userCardDto) {
        ApiResponse apiResponse = userCardService.addCard(id, userCardDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @GetMapping("/take/{id}")
    public ResponseEntity<ApiResponse> getCard(@PathVariable UUID id) {
        ApiResponse apiResponse = userCardService.getUserCard(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @GetMapping("takes/{id}")
    public ResponseEntity<ApiResponse> getAllCards(@PathVariable UUID id) {
        ApiResponse apiResponse = userCardService.getAllCards(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCard(@PathVariable UUID id) {
        ApiResponse apiResponse = userCardService.deleteCard(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
