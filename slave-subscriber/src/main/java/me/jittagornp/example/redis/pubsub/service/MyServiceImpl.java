package me.jittagornp.example.redis.pubsub.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author jitta
 */
@Slf4j
@Service
public class MyServiceImpl implements MyService {

    @Override
    public Mono<Void> start() {
        log.debug("starting...");
        return Mono.create(sink -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                //
            }
            log.debug("started");
            sink.success();
        });
    }

    @Override
    public Mono<Void> stop() {
        log.debug("stoping...");
        return Mono.create(sink -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                //
            }
            log.debug("stoped");
            sink.success();
        });
    }

    @Override
    public Mono<Void> restart() {
        log.debug("restarting...");
        return Mono.create(sink -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                //
            }
            log.debug("restarted");
            sink.success();
        });
    }

}
