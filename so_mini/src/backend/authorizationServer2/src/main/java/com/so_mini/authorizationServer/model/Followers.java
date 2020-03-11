package com.so_mini.authorizationServer.model;

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
@Table(name="followers")
public class Followers {
    @Id
    @Column(name ="follower_nickname")
    String follower_nickname;
    @Column(name = "u_idx",insertable = false, updatable = false)
    int u_idx;

    @ManyToOne
    @JoinColumn(name="u_idx")
    User user;

}