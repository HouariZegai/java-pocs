package com.houarizegai.springsecuritybasicauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.Collections;

import static com.houarizegai.springsecuritybasicauth.security.ApplicationUserPermission.*;
import static com.houarizegai.springsecuritybasicauth.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Important: order matter: top is higher
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(STUDENT_WRITE.getPermissions())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(STUDENT_WRITE.getPermissions())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(STUDENT_WRITE.getPermissions())
                .antMatchers( HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails houariUser = User.builder()
                .username("houari")
                .password(passwordEncoder.encode("root"))
                .authorities(STUDENT.getGrantedAuthorities()) // will be: ROLE_STUDENT
                .build();

        UserDetails mohamedUser = User.builder()
                .username("moh")
                .password(passwordEncoder.encode("pass"))
                .authorities(ADMIN.getGrantedAuthorities()) // ROLE_ADMIN
                .build();

        UserDetails fatimaUser = User.builder()
                .username("fatima")
                .password(passwordEncoder.encode("fati"))
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities()) // ROLE_ADMIN_TRAINEE
                .build();

        return new InMemoryUserDetailsManager(houariUser, mohamedUser, fatimaUser);
    }
}
