package com.projects.hroauth.config.customgrant;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class CustomUserAuthorities {

    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomUserAuthorities(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }
}
