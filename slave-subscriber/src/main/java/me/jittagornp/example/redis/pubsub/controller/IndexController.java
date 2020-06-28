package me.jittagornp.example.redis.pubsub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author jitta
 */
@RestController
public class IndexController {

    @GetMapping({"", "/"})
    public Mono<String> helloWorld() {
        return Mono.just("Spring-boot Reactive Redis Pub/Sub Example : Slave Node");
    }

}
