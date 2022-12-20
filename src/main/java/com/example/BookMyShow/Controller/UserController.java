package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResposeDto;
import com.example.BookMyShow.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser (@RequestBody UserEntry userEntry){
        userService.addUser(userEntry);
        return new ResponseEntity<>("User added Succesfully", HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResposeDto> getUser(@PathVariable(value = "id")int id){

        UserResposeDto userResponseDto = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}
