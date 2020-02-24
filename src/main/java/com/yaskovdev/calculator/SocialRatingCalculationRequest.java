package com.yaskovdev.calculator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
class SocialRatingCalculationRequest {

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @Min(1)
    private final int age;

    @Min(0)
    @Max(1)
    private final int calculationSeed;

    @JsonCreator
    SocialRatingCalculationRequest(@JsonProperty("firstName") final String firstName, @JsonProperty("lastName") final String lastName,
            @JsonProperty("age") final int age, @JsonProperty("calculationSeed") final int calculationSeed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.calculationSeed = calculationSeed;
    }
}
