package com.yereumi.posty.comment.domain;

import com.yereumi.posty.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "post_id")
    private Long postId;

    @Builder
    private Comment(String content, Integer likeCount, Long userId, Long postId) {
        this.content = content;
        this.likeCount = likeCount;
        this.userId = userId;
        this.postId = postId;
    }

    public static Comment of(String content, Integer likeCount, Long userId, Long postId) {
        return Comment.builder()
            .content(content)
            .likeCount(likeCount)
            .userId(userId)
            .postId(postId)
            .build();
    }

    public void updateComment(String content) {
        this.content = content;
    }

    // 일단 동시성 고려하지 않고 구현
    public void upLikeCount() {
        this.likeCount++;
    }

    public void downLikeCount() {
        this.likeCount--;
    }
}
