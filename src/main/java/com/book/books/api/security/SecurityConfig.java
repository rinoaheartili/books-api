package com.book.books.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author alberto
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
       http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
            .and()
        .addFilterBefore(new JWTAuthorizationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
    }
    
    /*private final JWTAuthorizationFilter jwtFilter;

    public SecurityConfig(JWTAuthorizationFilter jwtFilter) 
    {
        this.jwtFilter = jwtFilter;
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
    {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // público
                .anyRequest().authenticated()
            )
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception 
    {
        return config.getAuthenticationManager();
    }*/
    
}
