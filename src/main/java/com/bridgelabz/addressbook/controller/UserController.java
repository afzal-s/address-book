package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.service.IUserService;
import com.bridgelabz.addressbook.util.UToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UToken tokenutil;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> fetchUsersDataLists() {
        List<User> usersListData = userService.fetchUsersDataLists();
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users", usersListData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/users/sort")
    public ResponseEntity<ResponseDTO> fetchSortedUsersDataLists() {
        List<User> sortedUsersListData = userService.fetchSortedUsersDataLists();
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users In Sorting Order", sortedUsersListData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/users/city")
    public ResponseEntity<ResponseDTO> fetchUserDataByCityName(@RequestParam String city) {
        List<User> usersByCity = userService.fetchUserDataByCityName(city);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users By Given City", usersByCity);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/users/postcode") // Not Working
    public ResponseEntity<ResponseDTO> fetchUserDataByPostCode(@RequestParam String postCode) {
        List<User> userDataByPostCode = userService.fetchUserDataByPostCode(postCode);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users By Given PostCode", userDataByPostCode);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/user")
    public ResponseEntity<ResponseDTO> fetchUserById(@RequestHeader String token) {
        User userData = userService.fetchUserById(token);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetch User Data Of Given Id " +
                tokenutil.decodeToken(token), userData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/userbyfirstname")
    public ResponseEntity<ResponseDTO> fetchUserByFirstName(@RequestParam String firstName) {
        List<User> userData = userService.fetchUserByFirstName(firstName);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Fetched All Users By Given City", userData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        User userData = userService.saveUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO((long) 201, "User Created.",
                tokenutil.generateToken(userData.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/user")
    public ResponseEntity<ResponseDTO> deleteUserById(@RequestHeader String token) {
        userService.deleteUserById(token);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Deleted User Data Of Given Id: " +
                tokenutil.decodeToken(token));
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/user")
    public ResponseEntity<ResponseDTO> updateUserById(@Valid @RequestBody UserDTO userDTO, @RequestHeader String token) {
        User userData = userService.updateUserById(userDTO, token);
        ResponseDTO responseDTO = new ResponseDTO((long) 200, "Updated User Data Of Given Id " +
                tokenutil.decodeToken(token), userData);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}