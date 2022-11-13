package com.example.demo.sequrity;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.demo.filter.CustomAuthenticationFilter;
import com.example.demo.filter.CustomAuthorizationFilter;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Lazy
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/api/users").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/api/v1/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "api/user/**").hasAnyAuthority("ROLE_USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		
		http.addFilter(new CustomAuthenticationFilter(authenticationManager));
		http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
//	@Bean
//	public FilterRegistrationBean simpleCorsFilter() {  
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
//	    CorsConfiguration config = new CorsConfiguration();  
//	    config.setAllowCredentials(true); 
//	    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); 
//	    config.setAllowedOrigins(Collections.singletonList("localhost:4200")); 
//	    config.setAllowedMethods(Collections.singletonList("*"));  
//	    config.setAllowedHeaders(Collections.singletonList("*"));  
//	    source.registerCorsConfiguration("/**", config);  
//	    FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
//	    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
//	    return bean;  
//	}  
	
	
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
		return (web) -> web.ignoring().antMatchers("/images/**");
	}
	
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
}
