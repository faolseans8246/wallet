package org.example.wallet.component;


import lombok.RequiredArgsConstructor;
import org.example.wallet.entity.Registration;
import org.example.wallet.repository.RegistrationRepos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrationLoader implements CommandLineRunner {

    private final RegistrationRepos registrationRepos;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) {

        if (initMode.equals("never")) {
            Registration registration = new Registration();
            registration.setUsername("login");
            registration.setEmail("email_12@gmail.com");
            registration.setPassword("parol");
            registration.setConfirmPassword("parol");
            registrationRepos.save(registration);
        }
    }
}
