package com.fartone.cardapp.controller;

// public class CardInfoController {

// package com.example.usercardapp.controller;

import com.fartone.cardapp.model.CardInfo;
import com.fartone.cardapp.service.CardInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/cards")
@RequiredArgsConstructor
public class CardInfoController {

    private final CardInfoService cardInfoService;

    @GetMapping
    public List<CardInfo> getCardsByUserId(@PathVariable Long userId) {
        return cardInfoService.getCardsByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<CardInfo> addCardToUser(@PathVariable Long userId, @RequestBody CardInfo cardInfo) {
        return cardInfoService.addCardToUser(userId, cardInfo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long userId, @PathVariable Long cardId) {
        // userId is not strictly needed here for deletion if cardId is unique,
        // but it's good practice for RESTful URI design.
        return cardInfoService.deleteCard(cardId) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
