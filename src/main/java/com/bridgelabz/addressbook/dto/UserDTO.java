package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Pattern( regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "First Letter Should Be Capital")
    private String firstName;

    @Pattern( regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "First Letter Should Be Capital")
    private String lastName;

    @Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
            message="Email Is Not Valid")
    private String email;

    @Pattern(regexp="Male|Female",
            message="Gender Should Be Male Or Female")
    private String gender;

    @Pattern(regexp="^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message="Mobile is not in proper format")
    private String mobileNumber;

    private AddressDTO address;
}
