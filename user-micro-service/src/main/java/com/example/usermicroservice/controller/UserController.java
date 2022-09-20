package com.example.usermicroservice.controller;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.service.UserService;
import com.example.usermicroservice.vo.Greeting;
import com.example.usermicroservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Greeting greeting;
    private final UserService userService;

    @PostMapping("/users")
    public String createUser(@RequestBody RequestUser user) {
        userService.createUser(user.toDto());

        return "Create user method is called";
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }
}