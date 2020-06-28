package me.jittagornp.example.redis.pubsub.service;

import reactor.core.publisher.Mono;

/**
 * @author jitta
 */
public interface MyService {

    Mono<Void> start();

    Mono<Void> stop();

    Mono<Void> restart();

}
