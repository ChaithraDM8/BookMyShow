package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.TicketDto;
import com.example.BookMyShow.Entity.TicketEntity;

public class TicketConvertor {
    public static TicketEntity dtoToEntity(TicketDto ticketDto) {
    return TicketEntity.builder()
            .allotedSeat(ticketDto.getAllotedSeat())
            .amount(ticketDto.getAmount())
            .bookedDate(ticketDto.getBookedDate()).build();
    }

    public static TicketDto entityToDto(TicketEntity ticketEntity) {
        return TicketDto.builder()
                .ticketId(ticketEntity.getId())
                .allotedSeat(ticketEntity.getAllotedSeat())
                .bookedDate(ticketEntity.getBookedDate())
                .amount(ticketEntity.getAmount()).build();
    }
}
