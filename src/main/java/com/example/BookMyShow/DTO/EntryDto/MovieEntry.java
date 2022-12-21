package com.example.BookMyShow.DTO.EntryDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Builder
public class MovieEntry {
     String movieName;
       Date releaseDate;
}
