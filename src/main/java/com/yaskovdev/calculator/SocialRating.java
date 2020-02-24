package com.yaskovdev.calculator;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("ratings")
class SocialRating {

    @Id
    private final String personId;

    private final int value;
}
