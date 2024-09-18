package org.example.wallet.service;

import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.LoginDto;
import org.example.wallet.dto.RegistrationDto;
import org.example.wallet.entity.Registration;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.repository.RegistrationRepos;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepos registrationRepos;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse registrationFunc(RegistrationDto registrationDto) {

        Optional<Registration> checkUsername = registrationRepos.findByUsername(registrationDto.getUsername());
        if (checkUsername.isPresent())
            return new ApiResponse("Username already excist!", true);

        Optional<Registration> checkEmail = registrationRepos.findByEmail(registrationDto.getEmail());
        if (checkEmail.isPresent())
            return new ApiResponse("Email already excist!", true);

        if (!(registrationDto.getPassword().equals(registrationDto.getConfirmPassword())))
            return new ApiResponse("Passwords do not match", true);

        Registration registration = new Registration();
        registration.setUsername(registrationDto.getUsername());
        registration.setEmail(registrationDto.getEmail());
        registration.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        registration.setConfirmPassword(registrationDto.getConfirmPassword());
        registrationRepos.save(registration);

        return new ApiResponse("Registration succesful", true);
    }


    public ApiResponse loginFunction(LoginDto loginDto) {

        Optional<Registration> usernameChecking = registrationRepos.findByUsername(loginDto.getUsername());
        if (usernameChecking.isEmpty())
            usernameChecking = registrationRepos.findByEmail(loginDto.getUsername());

        if (usernameChecking.isEmpty())
            return new ApiResponse("This username is not exciest!", false);

        Registration registration = usernameChecking.get();
        if (!passwordEncoder.matches(loginDto.getPassword(), registration.getPassword()))
            return new ApiResponse("Passwords do not match", false);

        return new ApiResponse("Login successful", true);
    }
}
