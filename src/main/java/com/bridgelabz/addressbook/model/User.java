package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.bridgelabz.addressbook.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_tb")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private Address address;

    private LocalDate registerDate;
    private LocalDate updateDate;

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.mobileNumber = userDTO.getMobileNumber();
        this.address = getAddress(userDTO.getAddressDTO());
        this.registerDate = LocalDate.now();
    }

    public Address getAddress(AddressDTO addressDTO) {
        Address address = new Address(addressDTO);
        return address;
    }

    public User() {}
}
