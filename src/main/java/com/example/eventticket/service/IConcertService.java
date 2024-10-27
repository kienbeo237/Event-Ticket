package com.example.eventticket.service;

import com.example.eventticket.entity.Concert;

import java.time.LocalDateTime;
import java.util.List;

public interface IConcertService {
    public List<Concert> searchConcerts(String keyword, String location, LocalDateTime startTime);
}
