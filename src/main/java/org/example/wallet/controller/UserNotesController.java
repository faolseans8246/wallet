package org.example.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.UserNotesDto;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.service.UserNotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserNotesController {

    private final UserNotesService userNotesService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getUser(@PathVariable UUID id) {
        ApiResponse apiResponse = userNotesService.getUserNotes(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getAllYsers() {
        ApiResponse apiResponse = userNotesService.getUserNoteById();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserNotesDto userNotesDto) {
        ApiResponse apiResponse = userNotesService.createNewUser(userNotesDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable UUID id, @RequestBody UserNotesDto userNotesDto) {
        ApiResponse apiResponse = userNotesService.updateUserNote(id, userNotesDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable UUID id) {
        ApiResponse apiResponse = userNotesService.deleteUserNote(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
