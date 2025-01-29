package com.pollingapp.api.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollService {

    private final PollRepository pollRepository;

    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> getPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(Long pollId) {
        return pollRepository.findById(pollId).orElseThrow(() -> new PollNotFoundException(pollId));
    }

    public void createPoll(Poll poll) {
        poll.setCreatedAt(LocalDateTime.now());
        pollRepository.save(poll);
    }

    public void deletePoll(Long pollId) {
        pollRepository.deleteById(pollId);
    }

    public void patchPoll(Long id, Poll newPoll) {

        pollRepository.findById(id)
                .map(poll -> {
                    poll.setTitle(newPoll.getTitle() != null ? newPoll.getTitle() : poll.getTitle());
                    poll.setDescription(newPoll.getDescription() != null ? newPoll.getDescription() : poll.getDescription());
                    return pollRepository.save(poll);
                })
                .orElseGet(() -> pollRepository.save(newPoll));
    }
}
