/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.configs;

import com.tth.filters.CustomAccessDeniedHandler;
import com.tth.filters.JwtAuthenticationTokenFilter;
import com.tth.filters.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author tongh
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tth.controllers",
    "com.tth.repositories",
    "com.tth.services",
    "com.tth.components"
})
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;

    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests().antMatchers("/api/login/").permitAll();
        http.authorizeRequests().antMatchers("/api/users/").permitAll();
        http.authorizeRequests().antMatchers("/api/lessor-post/").permitAll();
        http.authorizeRequests().antMatchers("/api/customer-post/").permitAll();
        http.authorizeRequests().antMatchers("/api/current-user/").permitAll();
        http.authorizeRequests().antMatchers("/api/lessor-post/**").permitAll();
        http.authorizeRequests().antMatchers("/api/customer-post/**").permitAll();
        http.authorizeRequests().antMatchers("/api/areas/").permitAll();
        http.authorizeRequests().antMatchers("/api/approve-user/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "api/posts/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**/comments/").permitAll();
        http.antMatcher("/api/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/approve-user/**")
                .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_LESSOR')")
                .antMatchers("/api/follow/**").access("hasRole('ROLE_USER')")
                .antMatchers("/api/comment/").access("hasRole('ROLE_USER') or hasRole('ROLE_LESSOR')")
                .antMatchers(HttpMethod.POST, "/api/approve-user/**")
                .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_LESSOR')")
                .antMatchers(HttpMethod.DELETE, "/api/approve-user/**")
                .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_LESSOR')")
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler())
                .and().cors().configurationSource(corsConfigurationSource());
    }
}
