package com.bridgelabz.addressbook.service.serviceimpl;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.repository.IUserRepository;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }


}
