package org.example.wallet.entity;


import jakarta.persistence.Entity;
import lombok.*;
import org.example.wallet.template.IdNotes;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "registration")
public class Registration extends IdNotes {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
