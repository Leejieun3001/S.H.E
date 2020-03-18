package com.so_mini.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Builder;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {

	private String idx;
	private String nickname;
	private String password;
	private List<GrantedAuthority> roles;
	private boolean enabled;

	public CustomUserDetails(String idx, String nickname, String password, List<GrantedAuthority> roles, boolean enabled) {
		this.idx = idx;
		this.nickname = nickname;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return nickname;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getIdx() {
		return idx;
	}

}

