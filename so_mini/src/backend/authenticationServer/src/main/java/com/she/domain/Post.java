package com.she.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="post")
public class Post {
	@Id
	@Column(name = "p_idx")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int p_idx;

	@Column(name = "p_regist_datetime")
	LocalDateTime p_regist_datetime;

	@Column(name = "p_img")
	String p_img;

	@Column(name = "p_location")
	String p_location;

	@Column(name = "likes_cnt")
	int likes_cnt;

	@Column(name = "coment_cnt")
	int coment_cnt;

	@Column(name = "p_writer")
	String p_writer;

	@Column(name = "p_content")
	String p_content;

	@JsonIgnore
	@OneToMany(mappedBy="post")
	List<Like> likes;

	@JsonIgnore
	@OneToMany(mappedBy="post")
	List<Comment> comments;

	@JsonIgnore
	@OneToMany(mappedBy="post")
	List<PostTag> post_tag;

	@Builder
	public Post(int p_idx, LocalDateTime p_regist_datetime, String p_img, String p_location, int likes_cnt, int coment_cnt, String p_writer, String p_content) {
		this.p_idx = p_idx;
		this.p_regist_datetime = p_regist_datetime;
		this.p_img = p_img;
		this.p_location = p_location;
		this.likes_cnt = likes_cnt;
		this.coment_cnt = coment_cnt;
		this.p_writer = p_writer;
		this.p_content = p_content;
	}

	@PrePersist
	protected void onCreate() {
		//p_regist_datetime = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	protected void onUpdate() {
		// p_regist_datetime = Timestamp.valueOf(LocalDateTime.now());
	}

	public List<Like> getLikes() {
		return likes;
	}

}
