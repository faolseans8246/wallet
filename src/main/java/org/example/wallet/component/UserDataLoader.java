package org.example.wallet.component;

import lombok.RequiredArgsConstructor;
import org.example.wallet.entity.UserNotes;
import org.example.wallet.enums.Gender;
import org.example.wallet.enums.Roles;
import org.example.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) {

        if (initMode.equals("never")) {
            UserNotes userNotes = new UserNotes();
            userNotes.setFirstName("Mustafo");
            userNotes.setLastName("Namozov");
            userNotes.setDay(19);
            userNotes.setMonth("December");
            userNotes.setYear(2019);
            userNotes.setPasswordId("AC0160973");
            userNotes.setJshshir("12345678901234");
            userNotes.setRegion("Tashkent");
            userNotes.setCity("Bektemir");
            userNotes.setStreet("Barkamol");
            userNotes.setHome(12);
            userNotes.setGender(Gender.MALE);
            userNotes.setRoles(Roles.USER);

            userRepository.save(userNotes);
        }

    }
}
