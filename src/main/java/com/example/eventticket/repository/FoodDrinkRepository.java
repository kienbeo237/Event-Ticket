package com.example.eventticket.repository;

import com.example.eventticket.entity.FoodDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDrinkRepository extends JpaRepository<FoodDrink, Long> {
}