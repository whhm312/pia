package com.pines.student.login;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pines.student.common.vo.Activity;
import com.pines.student.common.vo.Alarm;
import com.pines.student.common.vo.Notice;
import com.pines.student.common.vo.EmergencyContact;
import com.pines.student.login.vo.StudentLoginDetailsVO;

public interface StudentLoginService extends UserDetailsService {
	Collection<GrantedAuthority> getAuthorities(String username);
	List<Activity> getLoginActivities(String studentId);
	List<Alarm> getLoginAlarms(String studentId);
	List<EmergencyContact> getLoginEmergencyContacts(String studentId);
	List<Notice> getLoginNotices(String studentId);
	StudentLoginDetailsVO login(String studentId);
	void setLastLoginDate(String studentId);
}
