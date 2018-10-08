package com.cg.smartbucket.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.and()
		.formLogin()
		.successForwardUrl("/adminLoginSuccess");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username, password, enabled from user_details where username=?")
		.authoritiesByUsernameQuery("select sd.username, sr.role from user_role sr,user_details sd where sd.role_id = sr.role_id and sd.username=?")
		.passwordEncoder(new BCryptPasswordEncoder());
		
		System.out.println("Test authentucation **************");
		
	}
}
