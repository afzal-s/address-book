package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    public List<User> findUserByFirstName(String firstName);


//    public List<User> findUsersByCity(String city);
//    public List<User> findUsersByPostCode(String postCode);

}