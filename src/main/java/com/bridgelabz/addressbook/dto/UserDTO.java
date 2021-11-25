package com.bridgelabz.addressbook.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private AddressDTO addressDTO;

    public UserDTO() {}
}
