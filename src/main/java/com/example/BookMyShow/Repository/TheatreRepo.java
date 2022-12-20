package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<TheatreEntity,Integer> {
}
