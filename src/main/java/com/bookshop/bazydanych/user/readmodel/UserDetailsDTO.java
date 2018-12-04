package com.bookshop.bazydanych.user.readmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsDTO implements UserDetails {

	private static final long serialVersionUID = -5938391816736363631L;

	private long id;
	private String username;
	private String password;
	private String UUID;

	public UserDetailsDTO(long id, String username, String password, String uuid) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.UUID = uuid;
	}

    public UserDetailsDTO() {
    }

    @JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public long getId() {
		return id;
	}

	public String getUUID() {
		return UUID;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				   .append(id)
				   .append(username)
				   .build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserDetailsDTO) {
			UserDetailsDTO other = (UserDetailsDTO) obj;
			return new EqualsBuilder()
					   .append(id, other.getId())
					   .append(username, other.username)
					   .build();
		} else return false;
	}
}
