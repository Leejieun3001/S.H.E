package com.so_mini.authorizationServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * jieun
 * Security에 필요한 정보를 담기 위해 UserDetails를 상속받아 관련 필드를 Overriding
 */
@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "user") // 'user' 테이블과 매핑됨을 명시
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_idx")
    int uidx;

    @Column(name = "u_email")
    String email;

    @Column(name = "u_birth")
    Date date;

    String kakao_code;
    String google_code;

    @Column(name = "u_pwd")
    String pwd;

    Date regist_date;
    Date pw_update_date; //패스워드 변경일
    Date access_datetime;

    @Column(name = "u_name")
    String name;

    @Column(name = "u_nickname")
    String nickname;

    @Column(name = "u_gender")
    int gender;

    @Column(name = "u_phone")
    String phone;

    @Column(name = "u_photo")
    String photo;

    @Column(name = "u_msg")
    String msg;

    @Column(name = "u_grade")
    int grade;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Following> followings;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Followers> followers;


    public List<Following> getFollowing() {
        return followings;
    }


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.email;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}