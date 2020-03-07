package com.she.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="post_tag")
public class PostTag implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="p_idx")
	Post post;

	@Id
	@ManyToOne
	@JoinColumn(name="h_idx")
	Hashtag hashtag;

}
