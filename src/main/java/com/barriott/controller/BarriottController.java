package com.barriott.controller;

import com.barriott.domain.BookingDetails;
import com.barriott.domain.BookingRequest;
import com.barriott.domain.Room;
import com.barriott.service.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BarriottController {

    @Autowired
    RoomBookingService roomBookingService;

    @PostMapping("/bookRoom")
    public BookingDetails guestBookingDetails(@RequestBody BookingRequest bookingRequest)
    {
      return  roomBookingService.bookARoom(bookingRequest);
    }

    @GetMapping("/availableRooms")
    public Map<String,String> availableRooms(@RequestParam String requestDate)
    {
        return  roomBookingService.searchRoomsByDate(requestDate);
    }


    @GetMapping("/guestDetails")
    public List<BookingDetails>  guestBookingDetails(@RequestParam String guestName)
    {
        return  roomBookingService.searchBookingsByGuestName(guestName);
    }


}
