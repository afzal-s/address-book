package com.bridgelabz.addressbook.dto;

import com.bridgelabz.addressbook.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private AddressDTO addressDTO;
}
