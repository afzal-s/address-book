package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(UserDTO userDTO);
    List<User> fetchUsersDataLists();
    User fetchUserById(UserDTO userDTO, long id);
    void deleteUserById(long id);
    User updateUserById(UserDTO userDTO, long id);
}