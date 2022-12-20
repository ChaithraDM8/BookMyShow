package com.example.BookMyShow.DTO.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
public class ShowResponseDto {
    int id;

   Date showDate;

    Time showTime;

    MovieResponseDto movieResponseDto;

    TheaterResponseDto theaterDto;

}
