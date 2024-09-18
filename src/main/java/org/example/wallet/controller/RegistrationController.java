package org.example.wallet.controller;


import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.LoginDto;
import org.example.wallet.dto.RegistrationDto;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sign")
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping("/registration")
    public ResponseEntity<ApiResponse> registrationFunc(@RequestBody RegistrationDto registrationDto) {
        ApiResponse apiResponse = registrationService.registrationFunc(registrationDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginFunc(@RequestBody LoginDto loginDto) {
        ApiResponse apiResponse = registrationService.loginFunction(loginDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
