package com.akash.school.config;

import com.akash.school.handler.CustomAuthenticationFailureHandler;
import com.akash.school.handler.CustomAuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@RequiredArgsConstructor
@Configuration
public class ProjectSecurityConfig {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/", "/home", "/holidays/**", "/contact", "/saveMsg",
                                "/courses", "/about", "/assets/**","/login/**").permitAll())
                .formLogin(flc -> flc.loginPage("/login").usernameParameter("userId").passwordParameter("secretPassword")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true")
                        .successHandler(customAuthenticationSuccessHandler).failureHandler(customAuthenticationFailureHandler))
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}Akash#3344").authorities("read")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{bcrypt}$2a$12$WEessZq4WfJlx9x8qGe6C.8N1S7rCJdAn0jZthwvKhoZYIY7/JKvW")
                .authorities("admin")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * From Spring Security 6.3 version
     *
     * @return
     */
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }


}
