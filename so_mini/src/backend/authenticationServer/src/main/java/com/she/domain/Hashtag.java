package com.she.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="hashtag")
public class Hashtag {
	@Id
	@Column(name="h_id")
	int h_id;

	@Column(name="hashtag")
	String content;

//	@Column(name="p_id")


}
