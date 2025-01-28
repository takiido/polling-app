package com.pollingapp.api.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class PollConfig {

    PollService pollService;

    @Autowired
    public PollConfig(PollService pollService) {
        this.pollService = pollService;
    }

    @Bean
    CommandLineRunner runner(PollRepository repository) {
        return args -> {
            Poll poll = new Poll(
                    "Test poll",
                    "Test poll description",
                    LocalDateTime.of(2025, JANUARY, 28, 12, 30, 0)
            );

            Poll poll2 = new Poll(
                    "Test poll 2",
                    "Test poll 2 description",
                    LocalDateTime.of(2025, JANUARY, 28, 12, 30, 0)
            );

            pollService.createPoll(poll);
            pollService.createPoll(poll2);
        };
    }
}
