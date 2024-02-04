package com.example.demo01.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String userFirstName;
    private String userLastName;
    private String username;
    private String userPassword; // property isimlerini camel case şeklinde yazınız.
    private String userMail;
    private String role;
    private String status;
}
