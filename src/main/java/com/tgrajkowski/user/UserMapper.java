package com.tgrajkowski.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public UserDto mapToUserDto(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputStream, UserDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public UserDetails mapToUserDetails(Users user) {
        List<GrantedAuthority> userRoleList = user.getRoleList().stream()
                .map(role -> new SimpleGrantedAuthority(role.getCode()))
                .collect(Collectors.toList());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), userRoleList);
        return userDetails;
    }
    public Users mapToUserPasswordEncode(UserDto userDto) {
        Users user = new Users();
        user.setId(user.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return user;
    }
}
