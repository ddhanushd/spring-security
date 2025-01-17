package com.investor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http   
		        //.csrf().disable()
		        .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		        .and()
		        .authorizeRequests()
		        //.antMatchers("/public/**").permitAll()
		        .antMatchers("/public/**").hasRole("NORMAL")
		        .antMatchers("/v1/**").hasRole("ADMIN")
		        //.antMatchers("/v1/investor/**").hasRole("ADMIN")
		        .anyRequest()
		        .authenticated()
		        .and()
		        .httpBasic();
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("john").password(this.encoder().encode("dhanush")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("roshni").password(this.encoder().encode("abc")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}
}
