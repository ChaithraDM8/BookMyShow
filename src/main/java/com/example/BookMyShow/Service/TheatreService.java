package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.DTO.TheatreDto;
import org.springframework.stereotype.Service;


public interface TheatreService {
    TheaterResponseDto addTheatre(TheatreEntry theatreEntryDto);
    TheaterResponseDto getTheatreById(int id);
}
