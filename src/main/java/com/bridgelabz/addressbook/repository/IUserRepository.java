package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByFirstName(String firstName);

    @Query(value = "SELECT * FROM user_tb, " +
            "address_tb WHERE user_tb.address_id = address_tb.id AND address_tb.city = ?1",
          nativeQuery = true)
    List<User> findUsersByCity(String city);

    @Query(value = "SELECT * FROM user_tb, " +
            "address_tb WHERE user_tb.address_id = address_tb.id AND address_tb.post_code = ?1",
            nativeQuery = true)
     List<User> findUsersByPostCode(String postCode);

    @Query(value = "SELECT * FROM user_tb WHERE mobile_number = ?1", nativeQuery = true)
    User findUsersByMobileNumber(String mobileNumber);

}