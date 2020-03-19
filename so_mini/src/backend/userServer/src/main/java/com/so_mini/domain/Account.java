package com.so_mini.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name="user")
public class Account {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="u_idx")
	Integer idx;

	@Column(length=100, name="u_email")
	String email;

	@Column(name="u_birth")
	Date date;

	String kakao_code;
	String google_code;

	@Column(length=300, name="u_pwd")
	String password;

	@CreationTimestamp
	Date regist_date;

	Date pw_update_date; //패스워드 변경일

	@UpdateTimestamp
	Date access_datetime;

	@Column(name="u_name")
	String name;

	@Column(length=100, name="u_nickname", unique=true)
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
	@OneToMany(mappedBy="account")
	List<Following> followings;

	@JsonIgnore
	@OneToMany(mappedBy="account")
	List<Followers> followers;

	public List<Following> getFollowing() {
		return followings;
	}

	public void setGrade(String str) {
		this.grade = Integer.parseInt(str);
	}

	public String getGrade() {
		return String.valueOf(this.grade);
	}


}
