package com.so_mini.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @Column(name = "c_idx")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int c_idx;
    @Column(name = "p_idx")
    int p_idx;
    @Column(name = "c_writer")
    String c_writer;
    @Column(name = "c_content")
    String c_content;
    @Column(name = "c_regist_datetime")
    Date c_regist_datetime;

    @Builder
    public Comment(int c_idx, int p_idx, String c_writer, String c_content, Date c_regist_datetime) {
        this.c_idx = c_idx;
        this.p_idx = p_idx;
        this.c_writer = c_writer;
        this.c_content = c_content;
        this.c_regist_datetime = c_regist_datetime;
    }
}
