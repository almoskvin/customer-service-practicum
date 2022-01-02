package com.github.almoskvin.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void registerNotification(String message, String sender, Integer toCustomerId, String toCustomerEmail) {
        Notification notification = Notification
                .builder()
                .message(message)
                .sender(sender)
                .toCustomerId(toCustomerId)
                .toCustomerEmail(toCustomerEmail)
                .build();
        notificationRepository.save(notification);
    }
}
