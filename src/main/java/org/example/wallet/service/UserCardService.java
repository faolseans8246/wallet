package org.example.wallet.service;

import lombok.RequiredArgsConstructor;
import org.example.wallet.dto.UserCardDto;
import org.example.wallet.entity.UserCard;
import org.example.wallet.entity.UserNotes;
import org.example.wallet.enums.CardType;
import org.example.wallet.payload.ApiResponse;
import org.example.wallet.repository.UserCardRepos;
import org.example.wallet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCardService {

    private final UserCardRepos userCardRepos;
    private final UserRepository userRepository;

    public ApiResponse addCard(UUID userId, UserCardDto userCardDto) {

        Optional<UserNotes> findByUser = userRepository.findById(userId);
        if (findByUser.isEmpty()) {
            return new ApiResponse("User not found!", false);
        }

        UserCard userCard = new UserCard();

        userCard.setCard_number(userCardDto.getCard_number());
        userCard.setExp_month(userCardDto.getExp_month());
        userCard.setExp_year(userCardDto.getExp_year());
        userCard.setCardName(userCardDto.getCardName());

        // Miqdorda o'zgarishlar shakllanadi!
        userCard.setAmountValue(userCardDto.getAmountValue());

        userCard.setCardType(userCardDto.getCardType() == null ? CardType.HUMO : userCardDto.getCardType());
        userCard.setUser(userRepository.findById(userId).get());
        userCardRepos.save(userCard);

        return new ApiResponse("Cardd addition successfully", true, userCard);
    }


    public ApiResponse getUserCard(UUID userId) {
        Optional<UserCard> findById = userCardRepos.findById(userId);

        return findById.map(userCard -> new ApiResponse("User card found", true, userCard)).orElseGet(() -> new ApiResponse("User card not found", false));
    }


    public ApiResponse getAllCards(UUID userId) {
        Optional<UserNotes> findUsers = userRepository.findById(userId);
        if (findUsers.isEmpty())
            return new ApiResponse("User not found!", false);

        List<UserCard> userCards = userCardRepos.findAllByUserId(userId);
        return new ApiResponse("User cards found", true, userCards);
    }


    public ApiResponse deleteCard(UUID cardId) {
        Optional<UserCard> userCardId = userCardRepos.findById(cardId);
        if (userCardId.isEmpty())
            return new ApiResponse("User card not found!", false);

        userCardRepos.deleteById(cardId);
        return new ApiResponse("User card deleted", true, userCardId);
    }

}
