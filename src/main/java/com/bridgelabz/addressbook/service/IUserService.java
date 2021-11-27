package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;

import java.util.List;

public interface IUserService {
    List<User> fetchUsersDataLists();
    User fetchUserById(String token);
    List<User> fetchSortedUsersDataLists();
    List<User> fetchUserByFirstName(String firstName);
    List<User> fetchUserDataByCityName(String city);
    List<User> fetchUserDataByPostCode(String postCode);
    User saveUser(UserDTO userDTO);
    void deleteUserById(long id);
    User updateUserById(UserDTO userDTO, String token);
}