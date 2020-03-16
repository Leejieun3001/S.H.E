package com.so_mini.domain;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name="following")
public class Following {
	@Id
	String following_nickname;

	@ManyToOne
	@JoinColumn(name="u_idx")
	User user;



}
