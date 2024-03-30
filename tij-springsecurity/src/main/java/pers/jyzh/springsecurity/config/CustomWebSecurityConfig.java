package pers.jyzh.springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Slf4j
@EnableWebSecurity
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //
                .antMatchers("/echoNoAuth").permitAll() //
                .anyRequest().authenticated() //
                .and() //
                .csrf().disable() //
                .httpBasic();
    }
}
