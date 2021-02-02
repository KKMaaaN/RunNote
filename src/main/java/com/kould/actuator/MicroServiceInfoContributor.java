package com.kould.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MicroServiceInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("company.name","www.Kould.com") ;
        builder.withDetail("version","V1.0") ;
        builder.withDetail("author","Kould") ;
    }
}
