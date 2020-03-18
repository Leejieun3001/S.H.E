package com.so_mini.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Builder;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class CustomUserDetails implements UserDetails {

	private Integer idx; //customizing
	private String username; // = nickname
	private String password;
	private List<GrantedAuthority> roles;
	private boolean isEnabled;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

}

