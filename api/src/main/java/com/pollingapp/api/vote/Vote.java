package com.pollingapp.api.vote;

import com.pollingapp.api.option.Option;
import com.pollingapp.api.poll.Poll;

public class Vote {
    private final Long id;
    private final Poll poll;
    private final Option option;

    public Vote(Long id, Poll poll, Option option) {
        this.id = id;
        this.poll = poll;
        this.option = option;
    }
}