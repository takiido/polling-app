package com.pollingapp.api.option;

import com.pollingapp.api.poll.Poll;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class Option {

    @Id
    @SequenceGenerator(
            name = "option_sequence",
            sequenceName = "option_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "option_sequence"
    )
    private Long id;
    private String optionText;
    private int votesCount;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    public Option(Long id, String optionText, int votesCount, Poll poll) {
        this.id = id;
        this.optionText = optionText;
        this.votesCount = votesCount;
        this.poll = poll;
    }

    public Option(String optionText, int votesCount, Poll poll) {
        this.optionText = optionText;
        this.votesCount = votesCount;
        this.poll = poll;
    }
}