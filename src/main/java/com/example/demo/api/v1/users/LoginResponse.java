package com.example.demo.api.v1.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    
    private String msg;
    
    private Long userId;

}
