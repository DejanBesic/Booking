package com.booking.app.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String username;
		
		private Long id;
		
		private String token;
		
		private Collection<? extends GrantedAuthority > authorities;
	
		public JwtUserDetails(String username, Long id, String token, List<GrantedAuthority> grantedAuthorities){
			this.username = username;
			this.id = id;
			this.token =token;
			this.authorities = grantedAuthorities;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.authorities;
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
			return true;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
		

		public String getUsername() {
			return this.username;
		}


		public void setUsername(String username) {
			this.username = username;
		}

		public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
			this.authorities = authorities;
		}

		@Override
		public String getPassword() {
			return null;
		}
		

}
