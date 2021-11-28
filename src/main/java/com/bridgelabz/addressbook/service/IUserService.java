package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.exception.UserAlreadyExistsException;
import com.bridgelabz.addressbook.exception.UserNotFoundException;
import com.bridgelabz.addressbook.model.User;

import java.util.List;

public interface IUserService {
    List<User> fetchUsersDataLists() throws UserNotFoundException;
    User fetchUserById(String token) throws UserNotFoundException;
    List<User> fetchSortedUsersDataLists() throws UserNotFoundException;
    List<User> fetchUserByFirstName(String firstName) throws UserNotFoundException;
    List<User> fetchUserDataByCityName(String city) throws UserNotFoundException;
    List<User> fetchUserDataByPostCode(String postCode) throws UserNotFoundException;
    User saveUser(UserDTO userDTO) throws UserAlreadyExistsException;
    User deleteUserById(String token) throws UserNotFoundException;
    User updateUserById(UserDTO userDTO, String token) throws UserNotFoundException;
}