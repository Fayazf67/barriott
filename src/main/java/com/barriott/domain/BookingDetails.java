package com.barriott.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDetails {

    private String bookingId;
    private String guestName;
    private Room room;
    private String bookingDate;

}
