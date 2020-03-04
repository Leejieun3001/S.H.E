package com.she.domain;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name="following")
public class Following {
	@ManyToOne
	@JoinColumn(name="u_idx")
	User user;

	int following_idx;
	String following_nickname;

}
