package com.example.BookMyShow.Service;


import com.example.BookMyShow.DTO.BookRequestDto;
import com.example.BookMyShow.DTO.TicketDto;
import org.springframework.stereotype.Service;


public interface TicketService {
    public TicketDto addTicket(TicketDto ticketDto);
    public TicketDto getTicketById(int id);
    public TicketDto BookRequest(BookRequestDto bookRequestDto);
}
