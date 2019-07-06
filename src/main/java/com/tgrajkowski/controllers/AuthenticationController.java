package com.tgrajkowski.controllers;

import com.tgrajkowski.service.users.AuthenticationService;
import com.tgrajkowski.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController()
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public UserDto singUp(@RequestBody @Valid UserDto userDto) {
        System.out.println(userDto.toString());
        return authenticationService.singUp(userDto);
    }
}
