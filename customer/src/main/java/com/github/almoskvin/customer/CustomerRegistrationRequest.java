package com.github.almoskvin.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
