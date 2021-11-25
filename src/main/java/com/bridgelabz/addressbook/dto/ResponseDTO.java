package com.bridgelabz.addressbook.dto;

import com.bridgelabz.addressbook.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Long statusCode;
    private String message;
    private Object data;
}
