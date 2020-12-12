package com.houarizegai.springsecuritybasicauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import static com.houarizegai.springsecuritybasicauth.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name())
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
