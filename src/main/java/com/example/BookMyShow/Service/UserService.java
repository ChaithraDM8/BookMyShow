package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResposeDto;
import com.example.BookMyShow.DTO.UserDto;

public interface UserService {
     public void addUser(UserEntry userEntry);
     public UserResposeDto getUserById(int id);
}
