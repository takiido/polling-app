package com.pollingapp.api.option;

import com.pollingapp.api.poll.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {

    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @RequestMapping(path="api/v1/polloptions/{id}")
    @GetMapping
    public List<Option> getOptionsByPoll(Poll poll) {
        return this.optionService.getAllOptions(poll);
    }

    @RequestMapping(path="api/v1/option")
    @PostMapping
    public void createOption(@RequestBody Option option) {
        this.optionService.createOption(option);
    }

    @RequestMapping(path="api/v1/option/{id}")
    @DeleteMapping
    public void deleteOption(@PathVariable(value = "id") Long id) {
        optionService.deleteOption(id);
    }

    @RequestMapping(path = "api/v1/option/{id}")
    @PatchMapping
    public void PatchOption(@PathVariable(value = "id") Long id, @RequestBody Option option) {
        optionService.patchOption(id, option);
    }
}
