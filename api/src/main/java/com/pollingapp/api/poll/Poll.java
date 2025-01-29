package com.pollingapp.api.poll;


import com.pollingapp.api.option.Option;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class Poll {

    @Id
    @SequenceGenerator(
            name = "poll_sequence",
            sequenceName = "poll_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Option> options;

    public Poll(Long id, String title, String description, LocalDateTime expiredAt, List<Option> options) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expiredAt = expiredAt;
        this.options = options;
    }

    public Poll(String title, String description, LocalDateTime expiredAt, List<Option> options) {
        this.title = title;
        this.description = description;
        this.expiredAt = expiredAt;
        this.options = options;
    }

    public Poll(String title, String description, LocalDateTime expiredAt) {
        this.title = title;
        this.description = description;
        this.expiredAt = expiredAt;
    }
}
