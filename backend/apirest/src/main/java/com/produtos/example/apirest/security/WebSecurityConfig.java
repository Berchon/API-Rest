package com.produtos.example.apirest.security;

import ch.qos.logback.core.joran.action.NOPAction;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
             .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
             .anyRequest().authenticated()
             .and().httpBasic()
             .and().cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
             .and().csrf().disable()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//             .and().addFilterBefore(new TokenFilter(tokenService,userRepository), UsernamePasswordAuthenticationFilter.class);

//        http.csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/produtos").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().permitAll()
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("berchon").password("abc").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
