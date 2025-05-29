package com.projects.notification.services;

import com.projects.authlib.services.AuthService;
import com.projects.notification.entities.Notification;
import com.projects.notification.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final AuthService authService;

    public Page<Notification> findAllByUserId(Long userId, Pageable pageable) {
        authService.validateSelfOrAdmin(userId);
        return repository.findByUserId(userId, pageable);
    }
}
