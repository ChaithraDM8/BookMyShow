package com.example.BookMyShow.DTO;

import com.example.BookMyShow.enums.TheaterType;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TheatreDto {
    private int id;
    private String theatreName;
    private String address;
    private String city;
    TheaterType theaterType;

    //TheaterSeatsDto theaterSeatsDto;
    ShowDto showDto;
}
