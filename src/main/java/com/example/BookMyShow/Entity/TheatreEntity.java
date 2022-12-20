package com.example.BookMyShow.Entity;

import lombok.*;
import com.example.BookMyShow.enums.TheaterType;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Theatre")
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String theatreName;
    @Enumerated(EnumType.STRING)
    private TheaterType theaterType;
    private String address;
    private String city;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeatsEntity> theatreSeats;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
   private List<ShowEntity> shows;

}
