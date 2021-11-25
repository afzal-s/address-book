package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address_tb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private String postCode;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.country = addressDTO.country;
        this.postCode = addressDTO.postCode;
    }
}
