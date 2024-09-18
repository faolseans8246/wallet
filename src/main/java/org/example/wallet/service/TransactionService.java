package org.example.wallet.service;


import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.TransactionDto;
import org.example.wallet.entity.Transactions;
import org.example.wallet.entity.UserCard;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.repository.TransactionRepos;
import org.example.wallet.repository.UserCardRepos;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {


    private final TransactionRepos transactionRepos;
    private final UserCardRepos userCardRepos;

    public ApiResponse makeTransaction(UUID cardId, TransactionDto transactionDto) {
        Optional<UserCard> fromCard = userCardRepos.findById(cardId);
        if (fromCard.isEmpty())
            return new ApiResponse("Card not found", false);

        UserCard card = fromCard.get();
        if (card.getAmountValue() < transactionDto.getAmount())
            return new ApiResponse("Not enough value", false);

        card.setAmountValue(card.getAmountValue() - transactionDto.getAmount());
        userCardRepos.save(card);

        Transactions transactions = new Transactions();
        transactions.setFromCard(card);
        transactions.setToCard(transactions.getToCard());
        transactions.setAmount(transactionDto.getAmount());
        transactions.setDescription(transactionDto.getDescription());
        transactions.setLocalTime(LocalDateTime.now());
        transactionRepos.save(transactions);

        return new ApiResponse("Transaction saved", true, transactions);
    }
}
