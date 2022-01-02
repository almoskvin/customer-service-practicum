package com.github.almoskvin.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification", path = "api/v1/notify/")
public interface NotificationClient {
    @PostMapping
    void notify(@RequestBody NotificationRequest request);
}
