package com.fartone.cardapp.repository;

// public class CardInfoRepository {
// package com.example.usercardapp.repository;

import com.fartone.cardapp.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {

    // Named Method
    List<CardInfo> findByExpirationDateBefore(LocalDate date);
}


