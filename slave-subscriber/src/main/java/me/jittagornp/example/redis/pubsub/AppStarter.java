package me.jittagornp.example.redis.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jittagornp.example.redis.pubsub.service.MyService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.ReactiveSubscription.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.ReactiveRedisMessageListenerContainer;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ComponentScan(basePackages = "me.jittagornp")
@Slf4j
@RequiredArgsConstructor
public class AppStarter implements ApplicationRunner {

    private static final String CHANNEL_TOPIC_NAME = "my-cluster";

    private final MyService myService;

    private final ReactiveRedisMessageListenerContainer redisMessageListenerContainer;

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("Slave node : Subscriber started...");
        redisMessageListenerContainer.receive(new ChannelTopic(CHANNEL_TOPIC_NAME))
                .map(Message::getMessage)
                .flatMap(message -> {
                    if ("start-service".equals(message)) {
                        return myService.start();
                    } else if ("stop-service".equals(message)) {
                        return myService.stop();
                    } else if ("restart-service".equals(message)) {
                        return myService.restart();
                    }
                    return Mono.empty();
                })
                .subscribe();
    }
}
