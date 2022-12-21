package com.example.BookMyShow.DTO.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TicketResponseDto {
    int id;
    String allotedSeats;
    int amount;
     private Date bookedDate;
     String userName;
    String movieName;
}
