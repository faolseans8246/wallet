package org.example.wallet.mapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wallet.dto.UserNotesDto;
import org.example.wallet.entity.UserNotes;
import org.example.wallet.enums.Gender;
import org.example.wallet.enums.Roles;

@Data
public class UserNotesMapper {

    public UserNotes toEntity(UserNotesDto userNotesDto) {
        UserNotes userNotes = new UserNotes();
        userNotes.setFirstName(userNotesDto.getFirstName());
        userNotes.setLastName(userNotesDto.getLastName());
        userNotes.setDay(userNotesDto.getDay());
        userNotes.setMonth(userNotesDto.getMonth());
        userNotes.setYear(userNotesDto.getYear());
        userNotes.setPasswordId(userNotesDto.getPasswordId());
        userNotes.setJshshir(userNotesDto.getJshshir());
        userNotes.setRegion(userNotesDto.getRegion());
        userNotes.setCity(userNotesDto.getCity());
        userNotes.setStreet(userNotesDto.getStreet());
        userNotes.setHome(userNotesDto.getHome());
        userNotes.setRoles((userNotesDto.getRoles() == null) ? Roles.USER : userNotesDto.getRoles());
        userNotes.setGender((userNotesDto.getGender() == null) ? Gender.OTHER : userNotesDto.getGender());

        return userNotes;
    }

    public void updateEntity(UserNotes existingUserNotes, UserNotesDto userNotesDto) {
        if (userNotesDto.getFirstName() != null) {
            existingUserNotes.setFirstName(userNotesDto.getFirstName());
        }
        if (userNotesDto.getLastName() != null) {
            existingUserNotes.setLastName(userNotesDto.getLastName());
        }
        if (userNotesDto.getDay() != 0) {
            existingUserNotes.setDay(userNotesDto.getDay());
        }
        if (userNotesDto.getMonth() != null) {
            existingUserNotes.setMonth(userNotesDto.getMonth());
        }
        if (userNotesDto.getYear() != 0) {
            existingUserNotes.setYear(userNotesDto.getYear());
        }
        if (userNotesDto.getPasswordId() != null) {
            existingUserNotes.setPasswordId(userNotesDto.getPasswordId());
        }
        if (userNotesDto.getJshshir() != null) {
            existingUserNotes.setJshshir(userNotesDto.getJshshir());
        }
        if (userNotesDto.getRegion() != null) {
            existingUserNotes.setRegion(userNotesDto.getRegion());
        }
        if (userNotesDto.getCity() != null) {
            existingUserNotes.setCity(userNotesDto.getCity());
        }
        if (userNotesDto.getStreet() != null) {
            existingUserNotes.setStreet(userNotesDto.getStreet());
        }
        if (userNotesDto.getHome() != 0) {
            existingUserNotes.setHome(userNotesDto.getHome());
        }
        if (userNotesDto.getRoles() != null) {
            existingUserNotes.setRoles(userNotesDto.getRoles());
        }
        if (userNotesDto.getGender() != null) {
            existingUserNotes.setGender(userNotesDto.getGender());
        }
    }
}
