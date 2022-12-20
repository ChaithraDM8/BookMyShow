package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.TheatreSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatsRepo extends JpaRepository<TheatreSeatsEntity,Integer> {
}
