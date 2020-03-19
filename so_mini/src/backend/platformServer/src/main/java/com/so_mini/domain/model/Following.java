package com.so_mini.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "following")
public class Following {
    @Id
    @Column(name = "following_nickname")
    String following_nickname;
    @Column(name = "u_idx", insertable = false, updatable = false)
    int u_idx;
    @ManyToOne
    @JoinColumn(name = "u_idx")
    User user;
}