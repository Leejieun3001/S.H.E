package com.she.domain;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name="hashtag")
public class Hashtag {
	@JsonIgnore
	@OneToMany(mappedBy="post_tag")
	List<PostTag> post_tag;

	String hashtag;
}
