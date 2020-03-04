package com.she.domain;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="c_idx")
	int c_idx;

	@ManyToOne
	@JoinColumn(name="p_idx")
	Post post;

	String c_writer;

	@Column(name="c_content")
	String content;

	Date c_regist_datetime;

}
