package com.barriott.domain;

import lombok.Data;
import org.springframework.context.annotation.Configuration;


@Data
//@Configuration
public class Room {
    public Room(int roomId, String status) {
        this.roomId = roomId;
        this.status = status;
    }

    private int roomId;
    private String status;

}
