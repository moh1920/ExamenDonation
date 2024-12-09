package org.sayari.examencroissant.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LogTime {

    @After("execution(* org.sayari.examencroissant.service.DonationService.addDonation(..))")
    public void logExecutionTime() {
        log.info("Merci pour ce don");
    }
}
