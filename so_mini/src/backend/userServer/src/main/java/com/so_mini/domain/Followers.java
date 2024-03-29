package com.so_mini.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="followers")
public class Followers {
	@Id
	String follower_nickname;

	@ManyToOne
	@JoinColumn(name="u_idx")
	Account account;

}
