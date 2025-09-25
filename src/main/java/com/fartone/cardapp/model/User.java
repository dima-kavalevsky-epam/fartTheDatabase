/**
* <p>This package contains the User class.</p>
 *
 * @author Anna Kovalevskaja
 * @version 1.0
 * @since 2025
  */
package com.fartone.cardapp.model;

// public class UserEntity {

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CardInfo> cardInfos = new ArrayList<>();

    public void addCardInfo(CardInfo cardInfo) {
        cardInfos.add(cardInfo);
        cardInfo.setUser(this);
    }

    public void removeCardInfo(CardInfo cardInfo) {
        cardInfos.remove(cardInfo);
        cardInfo.setUser(null);
    }
}
