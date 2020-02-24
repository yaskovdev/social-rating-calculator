package com.yaskovdev.calculator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class SocialRatingCalculationListener {

    private final SocialRatingRepository repository;

    @KafkaListener(topics = "social-rating-calculator", groupId = "social-rating")
    void listen(final SocialRatingCalculationRequest request) {
        final int rating = request.getAge() * request.getCalculationSeed();
        log.info("{} {} has {} rating", request.getFirstName(), request.getLastName(), rating);
        final String id = personId(request.getFirstName(), request.getLastName());
        repository.save(new SocialRating(id, rating));
    }

    private static String personId(final String firstName, final String lastName) {
        return (firstName + "." + lastName).trim().toLowerCase();
    }
}
