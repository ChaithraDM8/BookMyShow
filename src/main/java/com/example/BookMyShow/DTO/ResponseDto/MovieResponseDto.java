package com.example.BookMyShow.DTO.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {

    int id;
    String movieName;
    Date releaseDate;

    //Optional
    List<ShowResponseDto> showDtoList;
}

