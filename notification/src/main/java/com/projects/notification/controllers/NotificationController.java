package com.projects.notification.controllers;

import com.projects.notification.entities.Notification;
import com.projects.notification.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Page<Notification>> findAllByUserId(@PathVariable("id") Long userId, Pageable pageable) {
        return ResponseEntity.ok(service.findAllByUserId(userId, pageable));
    }
}
