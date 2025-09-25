/**
 *
 * <p>This package contains the CardInfo class.</p>
 *
 * @author Anna Kovalevskaja
 * @version 1.0
 * @since 2025
 *
 */
package com.fartone.cardapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "card_info")
@Data
@NoArgsConstructor
public class CardInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String holder;
    private LocalDate expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
