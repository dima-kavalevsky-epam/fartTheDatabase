package com.fartone.cardapp.service;

// public class CardInfoService {
// package com.example.usercardapp.service;

import com.fartone.cardapp.model.CardInfo;
import com.fartone.cardapp.model.User;
import com.fartone.cardapp.repository.CardInfoRepository;
import com.fartone.cardapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardInfoService {

    private final CardInfoRepository cardInfoRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<CardInfo> getCardsByUserId(Long userId) {
        return userRepository.findById(userId).map(User::getCardInfos).orElse(List.of());
    }

    @Transactional
    public Optional<CardInfo> addCardToUser(Long userId, CardInfo cardInfo) {
        return userRepository.findById(userId).map(user -> {
            user.addCardInfo(cardInfo);
            return cardInfoRepository.save(cardInfo);
        });
    }

    @Transactional
    public boolean deleteCard(Long cardId) {
        return cardInfoRepository.findById(cardId).map(cardInfo -> {
            cardInfoRepository.delete(cardInfo);
            return true;
        }).orElse(false);
    }
}
