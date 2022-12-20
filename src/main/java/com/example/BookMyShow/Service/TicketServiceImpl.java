package com.example.BookMyShow.Service;


import com.example.BookMyShow.Convertor.TicketConvertor;
import com.example.BookMyShow.DTO.BookRequestDto;
import com.example.BookMyShow.DTO.TicketDto;

import com.example.BookMyShow.Repository.ShowRepo;
import com.example.BookMyShow.Repository.TicketRepo;

import com.example.BookMyShow.Repository.UserRepo;
import com.example.BookMyShow.Entity.ShowEntity;
import com.example.BookMyShow.Entity.ShowSeatsEntity;
import com.example.BookMyShow.Entity.TicketEntity;
import com.example.BookMyShow.Entity.UserEntity;
import com.example.BookMyShow.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ShowRepo showRepo;

    @Override
    public TicketDto addTicket(TicketDto ticketDto) {
        TicketEntity ticketEntity= TicketConvertor.dtoToEntity(ticketDto);
       ticketRepo.save(ticketEntity);
       return ticketDto;
    }

    @Override
    public TicketDto getTicketById(int id) {
        TicketEntity ticketEntity =  ticketRepo.findById(id).get();
        return TicketConvertor.entityToDto(ticketEntity);
    }

    @Override
    public TicketDto BookRequest(BookRequestDto bookRequestDto) {
       UserEntity userEntity= userRepo.findById(bookRequestDto.getUserId()).get();
        ShowEntity showEntity=showRepo.findById(bookRequestDto.getShowId()).get();
        SeatType seatType=bookRequestDto.getSeatType();

       Set<String> requestedSeats=bookRequestDto.getRequestedSeats();
        List<ShowSeatsEntity> showSeats=showEntity.getShowSeats();
        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat:showSeats){
            if(!seat.isBooked() &&
            seat.getSeatType().equals(bookRequestDto.getSeatType()) &&
            requestedSeats.contains(seat.getSeatNum())){
                bookedSeats.add(seat);
            }
        }
        if(bookedSeats.size() != requestedSeats.size()){
            throw new Error("All Seats are not available");
        }
        TicketEntity ticketEntity=TicketEntity.builder().user(userEntity).shows(showEntity).seats(bookedSeats).build();

        int amount=0;
        for(ShowSeatsEntity seat:bookedSeats){
            seat.setBooked(true);
            seat.setBookedAt( new Date());
            seat.setTicket(ticketEntity);
            amount+= seat.getRate();
        }
        ticketEntity.setAmount(amount);
        ticketEntity.setBookedDate(new Date());
        ticketEntity.setAllotedSeat((convertListOfSeatsEntityToString(bookedSeats)));

        userEntity.getTickets().add(ticketEntity);
        showEntity.getTickets().add(ticketEntity);

        ticketRepo.save(ticketEntity);
        return TicketConvertor.entityToDto(ticketEntity);
    }
    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNum()+" ";
        }

        return str;

    }
}
