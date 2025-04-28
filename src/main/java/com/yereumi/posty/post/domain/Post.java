package com.yereumi.posty.post.domain;

import com.yereumi.posty.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "user_id") // 익명 글을 쓸 수 있으므로 nullable = true 로 설정
    private Long userId;

    @Builder
    private Post(String title, String content, Integer viewCount, Integer likeCount, Long userId) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.userId = userId;
    }

    public static Post of(String title, String content, Long userId) {
        return Post.builder()
            .title(title)
            .content(content)
            .viewCount(0)
            .likeCount(0)
            .userId(userId)
            .build();
    }

    public void updateInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 일단 동시성 고려하지 않고 구현
    public void updateViewCount() {
        this.viewCount++;
    }

    public void upLikeCount() {
        this.likeCount++;
    }

    public void downLikeCount() {
        this.likeCount--;
    }
}
