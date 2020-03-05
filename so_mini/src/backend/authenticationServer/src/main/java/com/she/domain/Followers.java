package com.she.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="followers")
public class Followers {
	@ManyToOne
	@JoinColumn(name="u_idx")
	User user;

	String follower_nickname;

}
