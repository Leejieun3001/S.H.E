package com.so_mini.authorizationServer.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails extends org.springframework.security.core.userdetails.User {
    private int uidx;



    public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public int getUidx() {
        return uidx;
    }

    public void setUidx(int uidx) {
        this.uidx = uidx;
    }
}
