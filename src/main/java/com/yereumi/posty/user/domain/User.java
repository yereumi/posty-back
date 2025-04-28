package com.yereumi.posty.user.domain;

import com.yereumi.posty.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password") // 소셜 로그인을 도입할 예정이므로 nullable = true 로 설정
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private Provider provider;

    @Column(name = "provider_id")
    private String providerId;

    @Builder
    private User(String username, String email, String password, String provider,
        String providerId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.provider = Provider.valueOf(provider);
        this.providerId = providerId;
    }

    public static User of(String username, String email, String password, String provider,
        String providerId) {
        return User.builder()
            .username(username)
            .email(email)
            .password(password)
            .provider(provider)
            .providerId(providerId)
            .build();
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
