package com.example.BookMyShow.DTO.EntryDto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class MovieEntry {
    String movieName;
       Date releaseDate;
}
