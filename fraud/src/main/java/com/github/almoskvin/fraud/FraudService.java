package com.github.almoskvin.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer id) {
        FraudHistoryCheck historyCheck = FraudHistoryCheck.builder()
                .customerId(id)
                .isFraudster(false)
                .build();
        fraudRepository.save(historyCheck);
        return false;
    }
}
