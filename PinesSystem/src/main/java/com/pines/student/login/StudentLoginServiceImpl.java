package com.pines.student.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pines.student.common.vo.Activity;
import com.pines.student.common.vo.Alarm;
import com.pines.student.common.vo.EmergencyContact;
import com.pines.student.common.vo.Notice;
import com.pines.student.login.vo.StudentLoginDetailsVO;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

	@Autowired
	StudentLoginDao studentLoginDao;

	@Override
	public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
		StudentLoginDetailsVO detail = studentLoginDao.loginSecurity(studentId);
		return detail;
	}

	public StudentLoginDetailsVO login(String studentId) throws UsernameNotFoundException {
		StudentLoginDetailsVO detail = studentLoginDao.loginSecurity(studentId);
		return detail;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		return new ArrayList<GrantedAuthority>();
	}

	@Override
	public List<Activity> getLoginActivities(String studentId) {
		return studentLoginDao.getLoginActivities(studentId);
	}

	@Override
	public List<Alarm> getLoginAlarms(String studentId) {
		return studentLoginDao.getLoginAlarms(studentId);
	}

	@Override
	public List<EmergencyContact> getLoginEmergencyContacts(String studentId) {
		return studentLoginDao.getLoginEmergencyContacts(studentId);
	}

	@Override
	public List<Notice> getLoginNotices(String studentId) {
		return studentLoginDao.getLoginNotices(studentId);
	}

	@Override
	public void setLastLoginDate(String loginId) {
		studentLoginDao.setLastLoginDate(loginId);
	}
}
