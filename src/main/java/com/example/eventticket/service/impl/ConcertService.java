package com.example.eventticket.service.impl;

import com.example.eventticket.entity.Concert;
import com.example.eventticket.repository.ConcertRepository;
import com.example.eventticket.service.IConcertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class ConcertService implements IConcertService {
    private final ConcertRepository concertRepository;
    @Override
    public List<Concert> searchConcerts(String keyword, String location, LocalDateTime startTime) {
        return concertRepository.findByKeywordLocationAndStartTime(keyword, location,startTime);
    }
}
