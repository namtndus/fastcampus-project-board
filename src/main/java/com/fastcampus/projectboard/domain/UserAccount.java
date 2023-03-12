package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Objects;

@Entity
public class UserAccount extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false, length = 50)
    private String userId;
    @Setter @Column(nullable = false) private String userPassword;

    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String nickname;

    @Setter private String memo;

    protected UserAccount() {}

    private UserAccount(String userId, String userPassword, String email, String nickname, String memo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
    }

    public UserAccount of(String userId, String userPassword, String email, String nickname, String memo) {
        return new UserAccount(userId,userPassword,email,nickname,memo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount userAccount)) return false;
        return id != null && id.equals(userAccount.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

