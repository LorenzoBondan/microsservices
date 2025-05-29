package com.projects.authlib.services;

import com.projects.authlib.feignclients.UserFeignClient;
import com.projects.authlib.utils.CustomUserUtil;
import com.projects.hrexceptionhandler.exceptions.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.projects.authlib.entities.User;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserFeignClient userFeignClient;
    private final CustomUserUtil customUserUtil;

    public User authenticated() {
        try {
            String username = customUserUtil.getLoggedUsername();
            return userFeignClient.findByEmail(username).getBody();
        }
        catch (Exception e) {
            throw new UsernameNotFoundException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long id) {
        User me = authenticated();
        if (me.hasRole("ROLE_ADMIN")) {
            return;
        }
        if(!me.getId().equals(id)) {
            throw new ForbiddenException("Access denied. Should be self or admin");
        }
    }

    public boolean isAdmin() {
        User user = authenticated();
        return user.hasRole("ROLE_ADMIN");
    }
}
