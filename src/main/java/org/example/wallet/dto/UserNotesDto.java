package org.example.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wallet.enums.Gender;
import org.example.wallet.enums.Roles;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotesDto {

    private String firstName;
    private String lastName;

    private int day;
    private String month;
    private int year;

    private String passwordId;
    private String jshshir;

    private String region;
    private String city;
    private String street;
    private int home;

    private Roles roles;
    private Gender gender;
}
