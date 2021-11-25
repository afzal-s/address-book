package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/addressbook")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO) {
        User userData = userService.saveUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO((long) 201, "User Created.", userData);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> fetchUsers() {
        List<User> usersListData = userService.fetchUsers();
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users", usersListData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}
