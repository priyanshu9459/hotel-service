package com.hotel.HotelService.repository;

import com.hotel.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}