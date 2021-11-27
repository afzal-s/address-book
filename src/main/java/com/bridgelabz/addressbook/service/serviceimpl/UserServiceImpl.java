package com.bridgelabz.addressbook.service.serviceimpl;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.repository.IUserRepository;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO);
        Address address = user.getAddress();
        user.setAddress(address);
        address.setUser(user);
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

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(UserDTO userDTO, long id) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()) {
            userData.get().setFirstName(userDTO.getFirstName());
            userData.get().setLastName(userDTO.getLastName());
            userData.get().setEmail(userDTO.getEmail());
            userData.get().setGender(userDTO.getGender());
            userData.get().setMobileNumber(userDTO.getMobileNumber());
            userData.get().setUpdateDate(LocalDate.now());

            Address address = userData.get().getAddress();
            address.setStreet(userDTO.getAddress().getStreet());
            address.setState(userDTO.getAddress().getState());
            address.setCountry(userDTO.getAddress().getCountry());
            address.setCity(userDTO.getAddress().getCity());
            address.setPostCode(userDTO.getAddress().getPostCode());

            return userRepository.save(userData.get());
        }
        return null;
    }
}