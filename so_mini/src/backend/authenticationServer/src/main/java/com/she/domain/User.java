package com.she.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="u_idx")
	int u_idx;

	@Column(name="u_email")
	String email;

	@Column(name="u_birth")
	Date date;

	String kakao_code;
	String google_code;

	@Column(name="u_pwd")
	String pwd;

	Date regist_date;
	Date pw_update_date; //패스워드 변경일
	Date access_datetime;

	@Column(name="u_name")
	String name;

	@Column(name="u_nickname")
	String nickname;

	@Column(name="u_gender")
	int gender;

	@Column(name="u_phone")
	String phone;

	@Column(name="u_photo")
	String photo;

	@Column(name="u_msg")
	String msg;

	@Column(name="u_grade")
	int grade;

	@JsonIgnore
	@OneToMany(mappedBy="user")
	List<Following> followers;

	public List<Following> getFollowing() {
		return followers;
	}

}
