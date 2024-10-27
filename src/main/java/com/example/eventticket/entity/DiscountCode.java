package com.example.eventticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Integer discountPercentage;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    @ManyToOne
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;
}

