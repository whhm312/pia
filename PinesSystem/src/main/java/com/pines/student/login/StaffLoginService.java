package com.pines.student.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StaffLoginService extends UserDetailsService {
	Collection<GrantedAuthority> getAuthorities(String username);
}
