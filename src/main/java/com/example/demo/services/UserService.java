package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.v1.users.LoginRequest;
import com.example.demo.api.v1.users.LoginResponse;
import com.example.demo.api.v1.users.RegisterRequest;
import com.example.demo.api.v1.users.RegisterResponse;
import com.example.demo.database.entities.User;
import com.example.demo.database.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMsg("Logged In...");
                loginResponse.setUserId(user.getId());
                return loginResponse;
            } else {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMsg("Invalid Username or Password ...");
                return loginResponse;
            }
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMsg("Invalid Username or Password ...");
        return loginResponse;
    }

    public RegisterResponse register(RegisterRequest registerRequest) {

        // Data From Request
        String username = registerRequest.getUsername();
        String password = registerRequest.getPassword();
        String phoneNumber = registerRequest.getPhoneNumber();
        String displayName = registerRequest.getDisplayName();

        // Empty User
        User newUser = new User();

        // Filling Empty User with Data
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setDisplayName(displayName);
        newUser.setPhoneNumber(phoneNumber);

        // Save User to Database
        userRepository.save(newUser);

        // Prepare Response
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMsg("User Created ...");
        return registerResponse;
    }

}
