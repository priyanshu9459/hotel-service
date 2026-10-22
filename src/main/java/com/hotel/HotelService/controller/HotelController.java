package com.hotel.HotelService.controller;

import com.hotel.HotelService.entity.Hotel;
import com.hotel.HotelService.repository.HotelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(
            @RequestBody Hotel hotel
    ) {

        Hotel savedHotel = hotelRepository.save(hotel);

        return ResponseEntity.ok(savedHotel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(
            @PathVariable Long id
    ) {

        return hotelRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}