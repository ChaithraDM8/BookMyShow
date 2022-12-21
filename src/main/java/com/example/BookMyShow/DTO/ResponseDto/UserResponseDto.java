package com.example.BookMyShow.DTO.ResponseDto;

import com.example.BookMyShow.DTO.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private long phNum;
    List<TicketDto> tickets;
}
