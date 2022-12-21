package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.BookMyShow.enums.SeatType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="ShowSeats")
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String seatNum;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private boolean booked;
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;


}
