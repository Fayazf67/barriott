package com.barriott.config;

import com.barriott.domain.BookingDetails;
import com.barriott.domain.BookingRequest;
import com.barriott.domain.Room;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@Data
public class BarriotHotel {

    @Value("${noOfRooms}")
    private int noOfRooms;

    private Room[] room =new Room[noOfRooms];

    private List<BookingDetails> bookingDetailsList =new ArrayList<>();

    Map<String,Room[]> DateRoomBookings = new HashMap<>();


}
