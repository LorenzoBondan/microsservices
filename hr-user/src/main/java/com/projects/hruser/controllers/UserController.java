package com.projects.hruser.controllers;

import com.projects.hrexceptionhandler.exceptions.ResourceNotFoundException;
import com.projects.hruser.entities.User;
import com.projects.hruser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}