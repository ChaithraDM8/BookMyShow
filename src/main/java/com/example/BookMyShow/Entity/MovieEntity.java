package com.example.BookMyShow.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private Date releaseDate;

    @OneToMany(mappedBy = "movie",cascade =CascadeType.ALL)
   private List<ShowEntity> shows;

}
