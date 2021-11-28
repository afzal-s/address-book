package com.bridgelabz.addressbook.service.serviceimpl;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.bridgelabz.addressbook.exception.UserAlreadyExistsException;
import com.bridgelabz.addressbook.exception.UserNotFoundException;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.repository.IUserRepository;
import com.bridgelabz.addressbook.service.IUserService;
import com.bridgelabz.addressbook.util.UToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UToken tokenutil;

    @Override
    public User saveUser(UserDTO userDTO) {
        User AlreadyExists = userRepository.findUsersByMobileNumber(userDTO.getMobileNumber());
        if (AlreadyExists == null) {
            User user = new User(userDTO);
            Address address = user.getAddress();

            user.setAddress(address);
            address.setUser(user);
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException("User Already Exists");

        }
    }

    @Override
    public List<User> fetchUsersDataLists() throws UserNotFoundException {
        List<User> usersList = userRepository.findAll();
        if (usersList.isEmpty())
            throw new UserNotFoundException("No Data Present");
        return usersList;
    }

    @Override
    public User fetchUserById(String token) throws UserNotFoundException {
        Optional<User> userData = userRepository.findById(tokenutil.decodeToken(token));
        if (userData.isEmpty())
            throw new UserNotFoundException("User Not Found Of Given Id: " + tokenutil.decodeToken(token));
        return userRepository.findById(tokenutil.decodeToken(token)).get();
    }

    @Override
    public List<User> fetchSortedUsersDataLists() throws UserNotFoundException {
        List<User> usersInSortedOrder = userRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        if (usersInSortedOrder.isEmpty())
            throw new UserNotFoundException("No Data Present");
        return usersInSortedOrder;
    }

    @Override
    public List<User> fetchUserByFirstName(String firstName) throws UserNotFoundException {
        List<User> usersDataByFirstName = userRepository.findUsersByFirstName(firstName);
        if (usersDataByFirstName.isEmpty())
            throw new UserNotFoundException("No Data Present");
        return usersDataByFirstName;
    }

    @Override
    public List<User> fetchUserDataByCityName(String city) throws UserNotFoundException {
        List<User> usersByCity = userRepository.findUsersByCity(city);
        if (usersByCity.isEmpty())
            throw new UserNotFoundException("User Not Present Of " + city + " City");
        return usersByCity;
    }

    @Override
    public List<User> fetchUserDataByPostCode(String postCode) throws UserNotFoundException {
        List<User> usersByPostCode = userRepository.findUsersByPostCode(postCode);
        if (usersByPostCode.isEmpty())
            throw new UserNotFoundException("User Not Present Of " + postCode + " PostCode");
        return usersByPostCode;
    }

    @Override
    public User deleteUserById(String token) throws UserNotFoundException {
        if (userRepository.findById(tokenutil.decodeToken(token)).isPresent()) {
            User deletedUser = fetchUserById(token);
            userRepository.deleteById(tokenutil.decodeToken(token));
            return deletedUser;
        } else {
            throw new UserNotFoundException(tokenutil.decodeToken(token) + " Given Id Is Not Present");
        }
    }

    @Override
    public User updateUserById(UserDTO userDTO, String token) throws UserNotFoundException {
        Optional<User> userData = userRepository.findById(tokenutil.decodeToken(token));
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
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }

}