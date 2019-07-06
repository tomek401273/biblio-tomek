package com.tgrajkowski.service.users;


import com.tgrajkowski.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    public UserDto singUp(UserDto userDto) {
        Users user = userMapper.mapToUserPasswordEncode(userDto);
        if (user != null) {
            List<Role> roles = new ArrayList<>();
            Role role = roleDao.findRoleByName("user");
            roles.add(role);
            user.setRoleList(roles);
            userDao.save(user);
            userDto.setId(user.getId());
            return userDto;
        }
        return null;
    }

}
