package com.example.eventticket.repository;

import com.example.eventticket.entity.Yard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YardRepository extends JpaRepository<Yard, Long> {
}