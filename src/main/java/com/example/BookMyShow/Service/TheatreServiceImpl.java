package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertor.TheatreConvertor;
import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.DTO.TheatreDto;
import com.example.BookMyShow.Repository.TheatreRepo;
import com.example.BookMyShow.Repository.TheatreSeatsRepo;
import com.example.BookMyShow.Entity.TheatreEntity;
import com.example.BookMyShow.Entity.TheatreSeatsEntity;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheaterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TheatreServiceImpl implements TheatreService{

    @Autowired
    TheatreRepo theatreRepo;
    @Autowired
    TheatreSeatsRepo theatreSeatsRepo;

    @Override
    public TheaterResponseDto addTheatre(TheatreEntry theatreEntryDto) {
        TheatreEntity theatreEntity= TheatreConvertor.dtoToEntity(theatreEntryDto);
        List<TheatreSeatsEntity> theatreSeats =createTheatreSeats();

        for(TheatreSeatsEntity theatreSeat:theatreSeats){
            theatreSeat.setTheatre(theatreEntity);
        }

       // theatreEntity.setTheaterType(TheaterType.SINGLE);
        theatreRepo.save(theatreEntity);
        theatreSeatsRepo.saveAll(theatreSeats);
        return TheatreConvertor.entityToDto(theatreEntity);

    }

    public List<TheatreSeatsEntity> createTheatreSeats() {
        List<TheatreSeatsEntity> seats=new ArrayList<>();
        seats.add(createTheatreSeat("A1",100,SeatType.CLASSIC));
        seats.add(createTheatreSeat("A2",100,SeatType.CLASSIC));
        seats.add(createTheatreSeat("A3",100,SeatType.CLASSIC));

        seats.add(createTheatreSeat("B1",200,SeatType.PREMIUM));
        seats.add(createTheatreSeat("B2",200,SeatType.PREMIUM));
        seats.add(createTheatreSeat("B3",200,SeatType.PREMIUM));
        return seats;

    }
    public TheatreSeatsEntity createTheatreSeat(String seatNum,int rate, SeatType seatType){
        return TheatreSeatsEntity.builder().seatNum(seatNum).rate(rate).seatType(seatType).build();
    }
    @Override
    public TheaterResponseDto getTheatreById(int id) {
        TheatreEntity theatreEntity=theatreRepo.findById(id).get();
        return TheatreConvertor.entityToDto(theatreEntity);
    }
}
