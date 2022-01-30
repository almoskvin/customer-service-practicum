package com.github.almoskvin.notification;

import com.github.almoskvin.clients.notification.NotificationRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/notify")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void notify(@RequestBody NotificationRequest request) {
        log.info("New notification request {}", request);
        if (request.message() == null || request.sender() == null) {
            throw new IllegalArgumentException("Error processing notification request: some params are null");
        }
        notificationService.send(request);
    }
}
