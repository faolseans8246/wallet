package org.example.wallet.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.wallet.enums.Gender;
import org.example.wallet.enums.Roles;
import org.example.wallet.template.IdNotes;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_notes")
public class UserNotes extends IdNotes {

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

    @Enumerated(EnumType.STRING)
    private Roles roles;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
