package com.github.almoskvin.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {
    private final FraudService fraudService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        boolean isFraudster = fraudService.isFraudulentCustomer(customerId);
        log.info("Fraud check for customer id {}: {}", customerId, isFraudster);
        return new FraudCheckResponse(isFraudster);
    }
}
