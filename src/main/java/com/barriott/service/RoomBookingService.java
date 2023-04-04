package com.barriott.service;

import com.barriott.config.BarriotHotel;
import com.barriott.domain.BookingDetails;
import com.barriott.domain.BookingRequest;
import com.barriott.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomBookingService {

    @Autowired
    private BarriotHotel barriotHotel;

    public BookingDetails bookARoom(BookingRequest bookingRequest) {

        Room room=new Room(bookingRequest.getRoomNo(),"BOOKED");

        BookingDetails bookingDetails=new BookingDetails();
        bookingDetails.setBookingId(UUID.randomUUID().toString());
        bookingDetails.setRoom(room);
        bookingDetails.setBookingDate(bookingRequest.getBookingDate());
        bookingDetails.setGuestName(bookingRequest.getGuestName());

        barriotHotel.getBookingDetailsList().add(bookingDetails);

        //Iterate through the dates with booking details and update the booking details
       //Keeping the details in map with Rooms with dates
        if(barriotHotel.getDateRoomBookings().get(bookingRequest.getBookingDate())!=null)
        {
            Room[] rooms= barriotHotel.getDateRoomBookings().get(bookingRequest.getBookingDate());
            Room bookedroom=new Room(bookingRequest.getRoomNo(),"BOOCKED");
            rooms[bookingRequest.getRoomNo()-1]=bookedroom;
        }
        else{
            Room[] rooms=new Room[barriotHotel.getNoOfRooms()];
            Room bookedroom=new Room(bookingRequest.getRoomNo(),"BOOCKED");
            rooms[bookingRequest.getRoomNo()-1]=bookedroom;
            barriotHotel.getDateRoomBookings().put(bookingRequest.getBookingDate(),rooms);
        }

        return bookingDetails;
    }


    public Map<String,String> searchRoomsByDate(String requestDate) {
        Map<String,String> availabileRooms=new HashMap<>();
        Room[] rooms=barriotHotel.getDateRoomBookings().get(requestDate);
        List<Room> availableRooms=new ArrayList<>();

        for (int i=0; i<rooms.length; i++) {
            if(rooms[0]==null)
            {
                availabileRooms.put("Room No "+i, "available");
            }

        }
        return availabileRooms;
    }

    public List<BookingDetails>  searchBookingsByGuestName(String guestName) {
       return barriotHotel.getBookingDetailsList().stream().filter(bookingRequest -> bookingRequest.getGuestName().equalsIgnoreCase(guestName)).collect(Collectors.toList());
    }
}
