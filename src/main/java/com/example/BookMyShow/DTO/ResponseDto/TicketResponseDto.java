package com.example.BookMyShow.DTO.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    int id;
    String allotedSeats;
    int amount;
    UserResposeDto userResposeDto;
    ShowResponseDto showResponseDto;
}
