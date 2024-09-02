package com.akash.springsecurity.config;

import com.akash.springsecurity.exceptionhandling.CustomBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Author: akash
 * Date: 26/8/24
 */

@Profile("!prod")
@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());*/
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());*/
        http.requiresChannel(channelRequestMatcherRegistry -> channelRequestMatcherRegistry.anyRequest().requiresInsecure()) // only HTTP
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices","/contact", "/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(httpBasicConfigurer -> httpBasicConfigurer.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        //http.exceptionHandling(httpBasicConfigurer -> httpBasicConfigurer.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint())); // Its a global config, which can handle all scenario's. But here we will use httpBasic
        return http.build();
    }

    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /***
     * From Spring Security 6.3 version
     * @return
     */
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
