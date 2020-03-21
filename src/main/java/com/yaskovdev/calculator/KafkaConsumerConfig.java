package com.yaskovdev.calculator;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;

@EnableKafka
@Configuration
@RequiredArgsConstructor
class KafkaConsumerConfig {

    @Bean
    ConsumerFactory<String, SocialRatingCalculationRequest> consumerFactory(final CalculatorConfig config) {
        final JsonDeserializer<SocialRatingCalculationRequest> deserializer = new JsonDeserializer<>(SocialRatingCalculationRequest.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("com.yaskovdev.collector");
        deserializer.setUseTypeMapperForKey(true);
        final Map<String, Object> props = of(BOOTSTRAP_SERVERS_CONFIG, config.getKafkaBootstrapServers(),
                GROUP_ID_CONFIG, "social-rating");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, SocialRatingCalculationRequest> kafkaListenerContainerFactory(
            final ConsumerFactory<String, SocialRatingCalculationRequest> consumerFactory) {
        final ConcurrentKafkaListenerContainerFactory<String, SocialRatingCalculationRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
