package com.pollingapp.api.poll;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    public Poll(Long id, String title, String description, LocalDateTime expiredAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expiredAt = expiredAt;
    }

    public Poll(String title, String description, LocalDateTime expiredAt) {
        this.title = title;
        this.description = description;
        this.expiredAt = expiredAt;
    }
}
