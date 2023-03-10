package org.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
/* WebSecurityConfigurerAdapter is not required for SecurityFilterChain */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * permitAll() allows full/public access to a specific or all resource/path inside a web application.
     * Used to allow public access to public access to public APIs, paths, CSS, images, JS files etc.
     * */
    /*
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
    }
    */

    /**
     * denyAll() denies full/public access to a specific or all resource/path inside a web application
     * Used to retire a specific API temporarily without removing code
     * */
    /*
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();
    }
    */

    /**
     * From Spring Security 5.7, the WebSecurityConfigurerAdapter is deprecated to encourage users
     * to move towards a component-based security configuration. It is recommended to create a bean
     * of type SecurityFilterChain for security related configurations.
     * @param httpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     * URL: http://localhost:8081/springboot/login
     */

    /*
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        *//** Permit All Requests inside the Web Application *//*
        httpSecurity.authorizeRequests().anyRequest().permitAll()
                        .and().formLogin()
                        .and().httpBasic();

        *//** Deny All Requests inside the Web Application *//*
        *//*
        httpSecurity.authorizeRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();
        *//*
        return httpSecurity.build();
    }
    */

    /**
     * We can apply custom security config based on our requirements for each API/URL.
     * permitAll() can be used to allow access w/o security and
     * authenticated() can be used to protect wep page/API.
     * URL: http://localhost:8081/springboot/login
     * Username: eazybytes
     * Password: 12345
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
            .authorizeRequests()
            /** Clicking on Dashboard link directly will redirect to login page as it is been authenticated */
            .mvcMatchers("/dashboard").authenticated()
            .mvcMatchers("/home").permitAll()
            .mvcMatchers("/holidays/**").permitAll()
            .mvcMatchers("/contact").permitAll()
            .mvcMatchers("/saveMsg").permitAll()
            .mvcMatchers("/courses").permitAll()
            .mvcMatchers("/about").permitAll()
            .mvcMatchers("/login").permitAll()
            .and().formLogin().loginPage("/login")
            .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
            .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
            .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("54321").roles("USER", "ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
