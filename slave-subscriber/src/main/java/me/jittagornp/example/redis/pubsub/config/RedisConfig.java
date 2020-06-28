package me.jittagornp.example.redis.pubsub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.listener.ReactiveRedisMessageListenerContainer;

/**
 *
 * @author jitta
 */
@Configuration
public class RedisConfig {

    @Bean
    public ReactiveRedisMessageListenerContainer redisMessageListenerContainer(final ReactiveRedisConnectionFactory factory) {
        return new ReactiveRedisMessageListenerContainer(factory);
    }

}
