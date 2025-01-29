package com.pollingapp.api.option;

import com.pollingapp.api.poll.Poll;
import com.pollingapp.api.poll.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {

    private final OptionService optionService;
    private final PollService pollService;

    @Autowired
    public OptionController(OptionService optionService, PollService pollService) {
        this.optionService = optionService;
        this.pollService = pollService;
    }

    @RequestMapping(path="api/v1/options/{id}", method = RequestMethod.GET)
    @GetMapping
    public List<Option> getOptionsByPoll(@PathVariable long id) {
        Poll poll = pollService.getPollById(id);
        return optionService.getAllOptions(poll);
    }

    @RequestMapping(path="api/v1/option", method = RequestMethod.POST)
    @PostMapping
    public void createOption(@RequestBody Option option) {
        optionService.createOption(option);
    }

    @RequestMapping(path="api/v1/option/{id}", method = RequestMethod.DELETE)
    @DeleteMapping
    public void deleteOption(@PathVariable(value = "id") Long id) {
        optionService.deleteOption(id);
    }

    @RequestMapping(path = "api/v1/option/{id}", method = RequestMethod.PATCH)
    @PatchMapping
    public void PatchOption(@PathVariable(value = "id") Long id, @RequestBody Option option) {
        optionService.patchOption(id, option);
    }
}
