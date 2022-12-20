package com.example.BookMyShow.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketDto {

    private int ticketId;
    private String allotedSeat;
    private int amount;
    private Date bookedDate;

    ShowDto showDto;
    UserDto userDto;
}
