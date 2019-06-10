package com.satya.springSecurity.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.satya.springSecurity.model.User;

public class JwtUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1013142558597946668L;
	private final String id;
	private final String username;
	private final String password;
	private final User user;
	private Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	
	public JwtUser(String id, String username, String password, User user,
			Collection<? extends GrantedAuthority> authorities, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
	}

	@JsonIgnore
	public String getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public User getUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
