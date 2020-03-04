package com.she.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="like")
public class Like {
	@Id
	@Column(name="u_nickname")
	String u_nickname;

	@ManyToOne
	@JoinColumn(name="p_idx")
	Post post;

}
