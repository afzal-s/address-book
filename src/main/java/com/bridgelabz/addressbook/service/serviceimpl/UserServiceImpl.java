package com.bridgelabz.addressbook.service.serviceimpl;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.repository.IUserRepository;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO);
        Address address = new Address(userDTO.getAddressDTO());
        System.out.println(address.toString());
        user.setAddress(address);
        System.out.println(user.toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUsersDataLists() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(UserDTO userDTO, long id) {
        return userRepository.findById(id).get();
    }

}
