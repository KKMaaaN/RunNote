package com.kould.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class BaseHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = 100 ;
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build() ;
        }
        return Health.up().build() ;
    }
}
