package com.github.almoskvin.clients.notification;

public record NotificationRequest(
        String message,
        String sender,
        Integer toCustomerId,
        String toCustomerEmail) {
}
