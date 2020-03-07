package com.she.domain;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name="hashtag")
public class Hashtag {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="h_idx")
	int h_idx;

	String hashtag;

	@JsonIgnore
	@OneToMany(mappedBy="hashtag")
	List<PostTag> post_tag;

}
