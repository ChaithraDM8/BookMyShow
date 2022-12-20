package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResposeDto;
import com.example.BookMyShow.Entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConvertor {
    public static UserEntity dtoToEntity(UserEntry userEntry){
        return UserEntity.builder().name(userEntry.getName()).phNum(userEntry.getPhNum()).build();
    }
    public static UserResposeDto entityToDto(UserEntity userEntity){
        return UserResposeDto.builder().id(userEntity.getId()).name(userEntity.getName()).phNum(userEntity.getPhNum()).build();
    }
}
