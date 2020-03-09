package com.so_mini.authorizationServer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name="following")
public class Following {
    @Id
    @Column(name ="following_nickname")
    String following_nickname;
    @Column(name = "u_idx", insertable = false, updatable = false)
    int u_idx;
    @ManyToOne
    @JoinColumn(name="u_idx")
    User user;
}