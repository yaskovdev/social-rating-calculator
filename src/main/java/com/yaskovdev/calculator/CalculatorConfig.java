package com.yaskovdev.calculator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "calculator")
class CalculatorConfig {

    @NotBlank
    private String kafkaBootstrapServers;
}
