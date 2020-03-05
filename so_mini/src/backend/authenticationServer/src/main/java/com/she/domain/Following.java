package com.she.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="following")
public class Following {
	@ManyToOne
	@JoinColumn(name="u_idx")
	User user;

	String following_nickname;

}
