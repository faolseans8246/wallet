package org.example.wallet.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.wallet.template.IdNotes;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "transactions")
public class Transactions extends IdNotes {

    @ManyToOne
    private UserCard fromCard;

    private String toCard;
    private double amount = 0.0;
    private String description;
    private LocalDateTime localTime;
}
