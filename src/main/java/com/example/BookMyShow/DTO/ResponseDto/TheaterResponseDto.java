package com.example.BookMyShow.DTO.ResponseDto;

import com.example.BookMyShow.enums.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterResponseDto {
    int id;
    String theaterName;
    String address;
    String city;
    TheaterType type;
}
