package com.github.almoskvin.customer;

import com.github.almoskvin.amqp.RabbitMQMessageProducer;
import com.github.almoskvin.clients.fraud.FraudCheckResponse;
import com.github.almoskvin.clients.fraud.FraudClient;
import com.github.almoskvin.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer messageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: check if email is valid
        // TODO: check is email not taken
        repository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        String message = String.format("Customer %s, %s verified and registered", customer.getLastName(), customer.getFirstName());
        NotificationRequest notificationRequest = new NotificationRequest(message, "Customer Service", customer.getId(), customer.getEmail());

        messageProducer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}

