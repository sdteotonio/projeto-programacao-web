package com.ufab.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

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
		.csrf().disable()
		.authorizeRequests()                                                                
				.antMatchers(
						"/",  
						"/assets/**"
						).permitAll()                  
				.antMatchers(
						"/curso/**",
						"/item/**",
						"/dividas/**",
						"/relatorio/**",
						"/reserva/**",
						"/usuario/**"
						).authenticated()                                  
				.anyRequest().authenticated()                                                   
         	.and()
         		.formLogin()
         		.failureUrl("/login?error=true")
         		.loginPage("/login")
         		.defaultSuccessUrl("/dash")
         		.permitAll()
         	.and()
         	.logout()
         	.logoutSuccessUrl("/")
         	.permitAll();
	}

}
