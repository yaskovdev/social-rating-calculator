package com.yaskovdev.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class SocialRatingCalculationListener {

    @KafkaListener(topics = "social-rating-calculator", groupId = "social-rating")
    void listen(final SocialRatingCalculationRequest request) {
        log.info("{} {} has {} score", request.getFirstName(), request.getLastName(), request.getAge() * request.getCalculationSeed());
    }
}
