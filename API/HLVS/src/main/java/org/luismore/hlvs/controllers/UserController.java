package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.domain.dtos.UserLoginDTO;
import org.luismore.hlvs.domain.dtos.UserRegisterDTO;
import org.luismore.hlvs.domain.entities.Token;
import org.luismore.hlvs.domain.entities.User;
import org.luismore.hlvs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> register(@RequestBody UserRegisterDTO userRegisterDto) {
        userService.create(userRegisterDto);
        return GeneralResponse.getResponse("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody UserLoginDTO userLoginDto) {
        User user = userService.findByUsernameOrEmail(userLoginDto.getUsername(), userLoginDto.getUsername());
        if (user == null || !userService.checkPassword(user, userLoginDto.getPassword())) {
            return GeneralResponse.getResponse(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
        Token token = userService.registerToken(user);
        return GeneralResponse.getResponse(token, "Login successful");
    }

    @PostMapping("/login/google")
    public ResponseEntity<GeneralResponse> googleLogin(@RequestBody String idToken) {
        Token token = userService.loginWithGoogle(idToken);
        if (token == null) {
            return GeneralResponse.getResponse(HttpStatus.UNAUTHORIZED, "Google login failed");
        }
        return GeneralResponse.getResponse(token, "Login successful");
    }
}

