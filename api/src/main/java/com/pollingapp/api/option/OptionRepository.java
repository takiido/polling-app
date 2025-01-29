package com.pollingapp.api.option;

import com.pollingapp.api.poll.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByPoll(Poll poll);
}