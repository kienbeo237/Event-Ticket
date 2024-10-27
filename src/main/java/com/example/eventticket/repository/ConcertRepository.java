package com.example.eventticket.repository;

import com.example.eventticket.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    @Query("SELECT c FROM Concert c WHERE "
            + "(LOWER(c.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR :keyword IS NULL) "
            + "AND (c.location = :location OR :location IS NULL) "
            + "AND (c.startTime >= :startTime OR :startTime IS NULL) ")
    List<Concert> findByKeywordLocationAndStartTime(
            @Param("keyword") String keyword,
            @Param("location") String location,
            @Param("startTime") LocalDateTime startTime);
}