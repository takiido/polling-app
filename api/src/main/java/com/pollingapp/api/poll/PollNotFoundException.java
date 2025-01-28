package com.pollingapp.api.poll;

public class PollNotFoundException extends RuntimeException {
    PollNotFoundException(Long id) {
        super("Poll not found with id " + id);
    }
}
