package me.jittagornp.example.redis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "me.jittagornp")
@Slf4j
public class AppStarter implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("Master node : Publisher started...");
    }
}
