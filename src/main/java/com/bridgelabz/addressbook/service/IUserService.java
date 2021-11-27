package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;

import java.util.List;

public interface IUserService {
    List<User> fetchUsersDataLists(); // Working
    User fetchUserById(String token); // Working
    List<User> fetchSortedUsersDataLists(); // Working
    List<User> fetchUserByFirstName(String firstName); // Working
    List<User> fetchUserDataByCityName(String city);
    List<User> fetchUserDataByPostCode(String postCode);

    User saveUser(UserDTO userDTO); // Working
    void deleteUserById(long id); // Working
    User updateUserById(UserDTO userDTO, String token); // Working

}