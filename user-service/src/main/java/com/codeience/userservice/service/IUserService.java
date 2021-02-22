package com.codeience.userservice.service;

import com.codeience.userservice.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserByEmail(String email);

}
