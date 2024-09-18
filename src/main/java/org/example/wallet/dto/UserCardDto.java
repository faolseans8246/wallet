package org.example.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wallet.enums.CardType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCardDto {

    private String card_number;
    private int exp_month;
    private int exp_year;
    private String cardName;
    private CardType cardType;

    private double amountValue = 0.0;
}
