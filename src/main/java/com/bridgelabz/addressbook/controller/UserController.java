package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO) {
        User userData = userService.saveUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO((long) 201, "User Created.", userData);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> fetchUsersDataLists() {
        List<User> usersListData = userService.fetchUsersDataLists();
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users", usersListData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> fetchUserById(@RequestBody UserDTO userDTO, @PathVariable long id) {
        User userData = userService.fetchUserById(userDTO, id);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetch User Data Of Given Id " + id, userData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Deleted User Data Of Given Id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateUserById(@RequestBody UserDTO userDTO, @PathVariable long id) {
        User userData = userService.updateUserById(userDTO, id);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Updated User Data Of Given Id " + id, userData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}