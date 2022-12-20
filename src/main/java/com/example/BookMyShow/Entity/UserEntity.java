package com.example.BookMyShow.Entity;


import com.example.BookMyShow.Entity.TicketEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name ="user")
public class UserEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phNum;

    @OneToMany(cascade=CascadeType.ALL)//(mappedBy = "user",cascade = CascadeType.ALL)
    @JoinColumn
    List<TicketEntity> tickets;

}
