package com.github.almoskvin.notification;

import com.github.almoskvin.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest request) {
        Notification notification = Notification
                .builder()
                .message(request.message())
                .sender(request.sender())
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .build();
        notificationRepository.save(notification);
    }
}
