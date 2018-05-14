package com.ufab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ufab.enumerador.TipoPerfil;

@EnableWebSecurity
@ComponentScan("com.ufab")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	private Md5PasswordEncoder encoder() {
		return new Md5PasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()                                                                
				.antMatchers(
						"/",  
						"/assets/**"
						).permitAll()                  
				.antMatchers(
						"/curso/**"
						).authenticated()                                  
				.anyRequest().authenticated()                                                   
         	.and()
         		.formLogin()
         		.failureUrl("/login?error=true")
         		.loginPage("/login")
         		.permitAll()
         	.and()
         	.csrf().disable();
	}

}
