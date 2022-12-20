package com.example.BookMyShow.DTO.EntryDto;

import com.example.BookMyShow.enums.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntry {
   private String theatreName;
   private String address;
   private String city;
   TheaterType theaterType;
}
