package com.she.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="post_tag")
public class PostTag {

	@ManyToOne
	@JoinColumn(name="p_idx")
	Post post;

	@ManyToOne
	@JoinColumn(name="h_idx")
	PostTag postTag;

}
