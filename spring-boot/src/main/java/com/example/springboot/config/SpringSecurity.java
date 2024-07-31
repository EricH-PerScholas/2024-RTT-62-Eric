package com.example.springboot.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.util.matcher.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurity {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // boiler plate code to protect a common hack
        http.csrf(csrf -> csrf.disable());

        // this section says allow all pages EXCEPT the ones that are in the AntPathRequestMatcher
        // anything in AntPathRequestMatcher will require the user to be authenticated
        // 1) users that are not logged in and can see any public resource
        // 2) users that are logged in but do not have any user roles to grant access to a resource
        // 3) users that are logged in AND have a user role that grants access to a resource
        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/admin/**"),
                        new AntPathRequestMatcher("/employee/**")).authenticated()
                .anyRequest().permitAll();


        // the loginPage parameter is the actual URL of the login page
        // the loginProcessingUrl is the URL that the form will submit to
        http.formLogin(formLogin -> formLogin
                // this a controller method URL for displaying the login page
                // we built this controller method, however this is just the URL in the browser for the login page
                .loginPage("/account/loginPageUrl")


                // this URL is part of spring security and we do not need to implement it in our controller
                // we just need to make the form action submit to this URL
                // this does not exist in any of our controller methods
                // 3 things need to be done on the login.jsp
                // 1) action needs to be set to /account/loginProcessingURL
                // 2) input field for username needs to be named "username"
                // 3) input field for password needs to be named "password"
                .loginProcessingUrl("/account/loginProcessingURL"));


        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                // this is the URL that will log a user out
                // this is another URL that is included with spring security - we do not have a controller method for this
                .logoutUrl("/account/logout")
                // after spring loggs the user out then it will goto this URL
                .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
