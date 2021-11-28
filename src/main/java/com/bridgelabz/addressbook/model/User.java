package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String mobileNumber;

    @JsonManagedReference
    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

    private LocalDate registerDate;
    private LocalDate updateDate;

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.mobileNumber = userDTO.getMobileNumber();
        this.gender = userDTO.getGender();
        this.password = userDTO.getPassword();
        this.address = new Address(userDTO.getAddress());
        this.registerDate = LocalDate.now();
    }
}