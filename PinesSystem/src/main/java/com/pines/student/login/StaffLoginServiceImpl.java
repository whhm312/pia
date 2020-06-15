package com.pines.student.login;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pines.student.login.vo.StaffLoginDetailsVO;

@Service
public class StaffLoginServiceImpl implements StaffLoginService {

	@Autowired
	StaffLoginDao staffLoginDao;

	@Override
	public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
		StaffLoginDetailsVO staffDetail = staffLoginDao.loginStaffSecurity(staffId);
		return staffDetail;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		return new ArrayList<GrantedAuthority>();
	}

}
