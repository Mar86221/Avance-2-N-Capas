package org.luismore.hlvs.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date timestamp;

    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Token(String content, User user) {
        this.content = content;
        this.timestamp = Date.from(Instant.now());
        this.active = true;
        this.user = user;
    }

    public Token() {
    }

    public void setToken(String token) {
        this.content = token;
    }
}
