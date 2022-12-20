package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Shows")
public class ShowEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private Date showDate;
    private Time showTime;
    private Date createdDate;
    private Time createdTime;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    @JsonIgnore
    List<TicketEntity> tickets;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> showSeats;

    @ManyToOne
    @JsonIgnore
    private MovieEntity movie;

    @ManyToOne
    @JsonIgnore
    private TheatreEntity theatre;



}
