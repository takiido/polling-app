package com.pollingapp.api.option;

import com.pollingapp.api.poll.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Option> getAllOptions(Poll poll) {
        return optionRepository.findAllByPoll(poll);
    }

    public void createOption(Option option) {
        optionRepository.save(option);
    }

    public void deleteOption(Long optionId) {
        optionRepository.deleteById(optionId);
    }

    public void patchOption(Long id, Option newOption) {

        optionRepository.findById(id)
                .map(option -> {
                    option.setOptionText(newOption.getOptionText() != null ? newOption.getOptionText() : option.getOptionText());
//                    option.setVotesCount(newOption.getVotesCount() != null ? newOption.getVotesCount() : option.getVotesCount());
                    return optionRepository.save(option);
                })
                .orElseGet(() -> optionRepository.save(newOption));
    }
}
