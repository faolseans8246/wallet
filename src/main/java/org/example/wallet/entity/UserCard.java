package org.example.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.wallet.enums.CardType;
import org.example.wallet.template.IdNotes;


@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_cards")
public class UserCard extends IdNotes {

    private String card_number;
    private int exp_month;
    private int exp_year;
    private String cardName;

    private double amountValue = 0.0;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @ManyToOne
    private UserNotes user;
}
