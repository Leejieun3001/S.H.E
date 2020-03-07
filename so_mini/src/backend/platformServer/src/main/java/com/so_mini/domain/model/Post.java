package com.so_mini.domain.model;


import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author : jieun
 * @Description : 개시물 엔티티
 */

@Entity
@Table(name = "post")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @Column(name = "p_idx")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int p_idx;
    @Column(name = "p_regist_datetime")
    LocalDateTime p_regist_datetime;
    @Column(name = "p_img")
    String p_img;
    @Column(name = "p_location")
    String p_location;
    @Column(name = "likes_cnt")
    int likes_cnt;
    @Column(name = "comment_cnt")
    int comment_cnt;
    @Column(name = "p_writer")
    String p_writer;
    @Column(name = "p_content")
    String p_content;

    @Builder
    public Post(int p_idx, LocalDateTime p_regist_datetime, String p_img, String p_location, int likes_cnt, int comment_cnt, String p_writer, String p_content) {
        this.p_idx = p_idx;
        this.p_regist_datetime = p_regist_datetime;
        this.p_img = p_img;
        this.p_location = p_location;
        this.likes_cnt = likes_cnt;
        this.comment_cnt = comment_cnt;
        this.p_writer = p_writer;
        this.p_content = p_content;
    }
    @PrePersist
    protected void onCreate() {
        //p_regist_datetime = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
       // p_regist_datetime = Timestamp.valueOf(LocalDateTime.now());
    }


}
