package com.pollingapp.api;

import com.pollingapp.api.option.Option;
import com.pollingapp.api.option.OptionService;
import com.pollingapp.api.poll.Poll;
import com.pollingapp.api.poll.PollService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class AppConfig {

    PollService pollService;
    OptionService optionService;

    public AppConfig(PollService pollService, OptionService optionService) {
        this.pollService = pollService;
        this.optionService = optionService;
    }

    @Bean
    CommandLineRunner runner(PollService pollService, OptionService optionService) {
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

            Option option1p1 = new Option(
                    "Poll 1 option 1",
                    0,
                    poll
            );

            List<Option> options = List.of(option1p1);

            poll.setOptions(options);

            pollService.createPoll(poll);
            pollService.createPoll(poll2);
            optionService.createOption(option1p1);
        };
    }
}
