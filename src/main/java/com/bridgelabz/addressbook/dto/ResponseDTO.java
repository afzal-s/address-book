package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseDTO {
    private Long statusCode;
    private String message;
    private Object data;

    public ResponseDTO(long statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
