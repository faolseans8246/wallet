package org.example.wallet.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wallet.entity.UserCard;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private UserCard fromCard;
    private String toCard;
    private double amount = 0.0;
    private String description;
}
