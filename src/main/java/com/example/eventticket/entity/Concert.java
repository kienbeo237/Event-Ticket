package com.example.eventticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private LocalDateTime startTime;

    @Column(nullable = false)
    private String location;

    private String image;

    @ManyToOne
    @JoinColumn(name = "concert_owner_id")
    private User concertOwner;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    // Constructors, Getters, Setters
}

