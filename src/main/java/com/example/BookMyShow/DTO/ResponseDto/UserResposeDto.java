package com.example.BookMyShow.DTO.ResponseDto;

import com.example.BookMyShow.Entity.TicketEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResposeDto {
    private int id;
    private String name;
    private long phNum;
    List<TicketEntity> tickets;
}
