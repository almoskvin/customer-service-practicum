package com.github.almoskvin;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
