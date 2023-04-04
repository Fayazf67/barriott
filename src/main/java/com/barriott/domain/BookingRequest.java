package com.barriott.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BookingRequest {

    private String guestName;
    private int roomNo;
    private String bookingDate;


}
