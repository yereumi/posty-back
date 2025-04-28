package com.yereumi.posty.like.domain;

import com.yereumi.posty.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "likes")
public class Like extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "target", nullable = false)
    private Target target;

    @Column(name = "target_id", nullable = false)
    private Long targetId;

    @Builder
    private Like(Target target, Long targetId) {
        this.target = target;
        this.targetId = targetId;
    }

    private static Like of(Target target, Long targetId) {
        return Like.builder()
            .target(target)
            .targetId(targetId)
            .build();
    }
}
