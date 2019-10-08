package com.thiagosb13.socialstats.controller;

import com.thiagosb13.socialstats.controller.dto.UserRequest;
import com.thiagosb13.socialstats.domain.User;
import com.thiagosb13.socialstats.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<User> findByName(@RequestParam(name = "name") String name) {
        return userService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public User save(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest.getName());
    }
}