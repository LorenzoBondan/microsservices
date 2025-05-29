package com.projects.authlib.services;

import com.projects.authlib.entities.User;
import com.projects.authlib.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Email not found: " + email);
        }
        return user;
    }
}
