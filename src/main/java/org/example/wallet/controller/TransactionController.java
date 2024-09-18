package org.example.wallet.controller;


import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.TransactionDto;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/prosess/{id}")
    public ResponseEntity<ApiResponse> transactionFunc(@PathVariable UUID id, @RequestBody TransactionDto transactionDto) {
        ApiResponse apiResponse = transactionService.makeTransaction(id, transactionDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
