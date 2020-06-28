package me.jittagornp.example.redis.pubsub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author jitta
 */
@RestController
@RequestMapping("/api/services")
@Slf4j
@RequiredArgsConstructor
public class ServiceController {

    private static final String CHANNEL_TOPIC_NAME = "my-cluster";

    private final ReactiveRedisOperations<String, String> redisOperations;

    @PostMapping("/start")
    public Mono<Void> start() {
        log.debug("{} : start-service", CHANNEL_TOPIC_NAME);
        return redisOperations.convertAndSend(CHANNEL_TOPIC_NAME, "start-service")
                .then();
    }

    @PostMapping("/stop")
    public Mono<Void> stop() {
        log.debug("{} : stop-service", CHANNEL_TOPIC_NAME);
        return redisOperations.convertAndSend(CHANNEL_TOPIC_NAME, "stop-service")
                .then();
    }

    @PostMapping("/restart")
    public Mono<Void> restart() {
        log.debug("{} : restart-service", CHANNEL_TOPIC_NAME);
        return redisOperations.convertAndSend(CHANNEL_TOPIC_NAME, "restart-service")
                .then();
    }
}
