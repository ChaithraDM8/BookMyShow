package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertor.ShowConvertor;
import com.example.BookMyShow.DTO.EntryDto.ShowEntry;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Entity.*;
import com.example.BookMyShow.Repository.MovieRepo;
import com.example.BookMyShow.Repository.ShowRepo;
import com.example.BookMyShow.Repository.ShowSeatsRepo;
import com.example.BookMyShow.Repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    ShowSeatsRepo showSeatsRepo;

    @Override
    public ShowResponseDto addShow(ShowEntry showEntry) {
        ShowEntity showEntity= ShowConvertor.dtoToEntity(showEntry);
    // getting movie to the show
        MovieEntity movieEntity= movieRepo.findById(showEntry.getMovieResponseDto().getId()).get();
    // getting theatre to the show
        TheatreEntity theatreEntity=theatreRepo.findById(showEntry.getTheaterResponseDto().getId()).get();
    // adding movie and theatre to the show
        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        List<ShowSeatsEntity> showSeatsEntity= createShowSeatsEntity(theatreEntity.getTheatreSeats(),showEntity);
        showEntity=showRepo.save(showEntity);
        showSeatsRepo.saveAll(showSeatsEntity);


        ShowResponseDto showResponseDto = ShowConvertor.entityToDto(showEntity,showEntry);

        return showResponseDto;
    }


    public List<ShowSeatsEntity> createShowSeatsEntity(List<TheatreSeatsEntity> theatreSeats,ShowEntity showEntity){
        List<ShowSeatsEntity> showSeats= new ArrayList<>();
        // adding same set of theater seats to show seats
        for(TheatreSeatsEntity seat:theatreSeats){
            showSeats.add(ShowSeatsEntity.builder()
                    .id(seat.getId())
                    .seatNum(seat.getSeatNum())
                    .rate(seat.getRate())
                    .seatType(seat.getSeatType())
                    .show(showEntity)
                    .build());
        }
        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeats){
            showSeatsEntity.setShow(showEntity);
        }
        showEntity.setShowSeats(showSeats);
        return showSeats;
    }

    @Override
    public ShowResponseDto getShowById(int id) {
       ShowEntity showEntity=showRepo.findById(id).get();
             return  ShowConvertor.entityToDto(showEntity);
    }
}
