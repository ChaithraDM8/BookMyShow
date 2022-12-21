package com.example.BookMyShow.DTO.EntryDto;

import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
public class ShowEntry {
    Date showDate;
   Time showTime;
    MovieResponseDto movieResponseDto;
    TheaterResponseDto theaterResponseDto;

}
