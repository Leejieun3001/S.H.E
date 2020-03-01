package com.so_mini.domain.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Table
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue
    int u_idx;

    @Column
    String u_email;
    @Column
    String kakao_code;
    @Column
    String google_code;
    @Column
    String u_pwd;
    @Column
    String regist_date;
    @Column
    String pw_update_date;
    @Column
    String access_datetime;
    @Column
    String u_name;
    @Column
    String u_nickname;
    @Column
    String u_sex;
    @Column
    String u_phone;
    @Column
    String u_photo;
    @Column
    String u_msg;
    @Column
    int u_grade;

    @Builder
    public User(int u_idx, String u_email, String kakao_code, String google_code, String u_pwd, String regist_date, String pw_update_date, String access_datetime, String u_name, String u_nickname, String u_sex, String u_phone, String u_photo, String u_msg, int u_grade) {
        this.u_idx = u_idx;
        this.u_email = u_email;
        this.kakao_code = kakao_code;
        this.google_code = google_code;
        this.u_pwd = u_pwd;
        this.regist_date = regist_date;
        this.pw_update_date = pw_update_date;
        this.access_datetime = access_datetime;
        this.u_name = u_name;
        this.u_nickname = u_nickname;
        this.u_sex = u_sex;
        this.u_phone = u_phone;
        this.u_photo = u_photo;
        this.u_msg = u_msg;
        this.u_grade = u_grade;
    }
}
