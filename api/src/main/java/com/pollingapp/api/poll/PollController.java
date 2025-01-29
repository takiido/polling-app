package com.pollingapp.api.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PollController {

    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @RequestMapping(path = "api/v1/poll", method = RequestMethod.GET)
    @GetMapping
    public List<Poll> getPolls() {
        return pollService.getPolls();
    }

    @RequestMapping(path = "api/v1/poll/{id}", method = RequestMethod.GET)
    @GetMapping
    public Poll getPollById(@PathVariable(value = "id") Long id) {
        return pollService.getPollById(id);
    }

    @RequestMapping(path = "api/v1/poll", method = RequestMethod.POST)
    @PostMapping
    public void createPoll(@RequestBody Poll poll) {
        pollService.createPoll(poll);
    }

    @RequestMapping(path = "api/v1/poll/{id}", method = RequestMethod.DELETE)
    @DeleteMapping
    public void deletePoll(@PathVariable(value = "id") Long id) {
        pollService.deletePoll(id);
    }

    @RequestMapping(path = "api/v1/poll/{id}", method = RequestMethod.PATCH)
    @PatchMapping
    public void patchPoll(@PathVariable(value = "id") Long id, @RequestBody Poll poll) {
        pollService.patchPoll(id, poll);
    }
}
