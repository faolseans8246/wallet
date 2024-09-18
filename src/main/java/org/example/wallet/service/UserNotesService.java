package org.example.wallet.service;

import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.UserNotesDto;
import org.example.wallet.entity.UserNotes;
import org.example.wallet.mapper.UserNotesMapper;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserNotesService {

    private final UserRepository userRepository;

    public ApiResponse getUserNotes(UUID userId) {
        Optional<UserNotes> getUserNotes = userRepository.findById(userId);
        return getUserNotes.map(users -> new ApiResponse("All user notes found", true, users))
                .orElseGet(() -> new ApiResponse("User not found", false));
    }

    public ApiResponse getUserNoteById() {
        List<UserNotes> getAllUsers = userRepository.findAll();

        if(getAllUsers.isEmpty())
            return new ApiResponse("User base is empty!", false);

        return new ApiResponse("All user notes", true, getAllUsers);
    }


    public ApiResponse createNewUser(UserNotesDto userNotesDto) {
        UserNotesMapper userNotesMapper = new UserNotesMapper();
        userRepository.save(userNotesMapper.toEntity(userNotesDto));
        return new ApiResponse("User notes created", true);
    }


    public ApiResponse updateUserNote(UUID userId, UserNotesDto userNotesDto) {
        Optional<UserNotes> getById = userRepository.findById(userId);

        if (getById.isEmpty())
            return new ApiResponse("User not found", false);

        UserNotes userNotes = getById.get();
        UserNotesMapper userNotesMapper = new UserNotesMapper();
        userNotesMapper.updateEntity(userNotes, userNotesDto);
        userRepository.save(userNotes);

        return new ApiResponse("User notes updated", true, userNotes);
    }

    public ApiResponse deleteUserNote(UUID userId) {
        Optional<UserNotes> deleteById = userRepository.findById(userId);
        if (deleteById.isEmpty())
            return new ApiResponse("User not found", false);

        userRepository.deleteById(userId);
        return new ApiResponse("User notes deleted", true);
    }
}
