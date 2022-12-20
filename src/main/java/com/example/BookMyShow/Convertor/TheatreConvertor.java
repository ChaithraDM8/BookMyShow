package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.DTO.TheatreDto;
import com.example.BookMyShow.Entity.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConvertor {

    public static TheaterResponseDto entityToDto(TheatreEntity theatreEntity) {
         return TheaterResponseDto.builder().id(theatreEntity.getId())
                 .theaterName(theatreEntity.getTheatreName())
                 .address(theatreEntity.getAddress())
                 .city(theatreEntity.getCity())
                 .type(theatreEntity.getTheaterType())
                 .build();
    }

    public static TheatreEntity dtoToEntity(TheatreEntry theatreDto) {
        return TheatreEntity.builder().city(theatreDto.getCity()).address(theatreDto.getAddress()).theatreName(theatreDto.getTheatreName()).theaterType(theatreDto.getTheaterType()).build();
    }
}
