package com.houarizegai.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.concurrent.TimeUnit;

import static com.houarizegai.springsecurity.security.ApplicationUserRole.*;

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
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
<<<<<<< HEAD
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/courses", true)
                    .usernameParameter("user") // default: username
                .and()
                .rememberMe() // default 2 weeks
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("somethingverysecured")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");
=======
                .loginPage("/login")
                .defaultSuccessUrl("/courses", true).permitAll()
                .and()
                .rememberMe() // default 2 weeks
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21));
>>>>>>> 75d348ef1f34ddb335351a9a7bb86641d772b307
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
