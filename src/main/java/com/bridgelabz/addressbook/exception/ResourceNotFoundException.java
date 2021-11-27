package com.bridgelabz.addressbook.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
