package com.pines.student.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pines.student.login.StaffLoginService;
import com.pines.student.login.StudentLoginService;

@EnableWebMvc
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HttpSecurityConfig extends WebSecurityConfigurerAdapter {
	private static String REALM = "MY_TEST_REALM";

	@Autowired
	private StaffLoginService staffLoginService;

	@Autowired
	private StudentLoginService studentLoginService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(staffLoginService);
		auth.userDetailsService(studentLoginService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.csrf().disable().authorizeRequests().
        antMatchers(
        		"/login/staff" 
        		, "/login"
        		, "/login/auto"
        		, "/filedownload"
        		, "/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/schedule/validate"
        		, "/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/schedule/students"
        		, "/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/schedule/teachers"
        		, "/branches/{branchSeq}/students/download"
        		, "/branches/{branchSeq}/campuses/{campusSeq}/entrances/records/download"
        		, "/exams/{examSeq}/students/download"
        		, "/conditions/branches"
        		, "/conditions/{branchSeq}/entrances/campuses"
        		, "/conditions/{branchSeq}/campuses/{campusSeq}/entrances"
        		, "/branches/{branchSeq}/campuses/{campusSeq}/entrances/records"
        		, "/pos/students/{studentId}/statement/download"
        		).permitAll().
		antMatchers("/**").hasAnyRole("ADMIN", "USER").
		and().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler()).
		and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint()).
		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		;
	}

	@Bean
	public PIABasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new PIABasicAuthenticationEntryPoint();
	}

	@Bean
	public AccessDeniedHandler getAccessDeniedHandler() {
		return new PIAAccessDeniedHandler();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}