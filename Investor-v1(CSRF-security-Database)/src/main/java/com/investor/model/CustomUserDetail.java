package com.investor.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {
	
	private Investors investors;
	
	

	public CustomUserDetail(Investors investors) {
		this.investors = investors;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		HashSet<SimpleGrantedAuthority> set=new HashSet<>();
		set.add(new SimpleGrantedAuthority("ROLE_"+this.investors.getRole()));
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.investors.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.investors.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
