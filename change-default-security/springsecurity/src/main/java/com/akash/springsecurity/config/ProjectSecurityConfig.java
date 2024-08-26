package com.akash.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Author: akash
 * Date: 26/8/24
 */

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());*/
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());*/
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices","/contact","/error"));
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build(); // noop means, I don't want to use any password encoder. So the password will be in plain text
        UserDetails admin = User.withUsername("admin").password("{noop}54321").authorities("admin").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
