package com.example.BookMyShow.Service;

import com.example.BookMyShow.Convertor.UserConvertor;
import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResposeDto;
import com.example.BookMyShow.Repository.UserRepo;
import com.example.BookMyShow.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Override
    public void addUser(UserEntry userEntry) {
    UserEntity userEntity= UserConvertor.dtoToEntity(userEntry);
    userRepo.save(userEntity);
    }

    @Override
    public UserResposeDto getUserById(int id) {
      UserEntity userEntity =  userRepo.findById(id).get();
      return UserConvertor.entityToDto(userEntity);
    }
}
