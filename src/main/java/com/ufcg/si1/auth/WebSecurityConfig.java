package com.ufcg.si1.auth;

import com.google.common.collect.ImmutableList;
import com.ufcg.si1.util.Paths;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String TOKEN_HEADER = "Authorization";
    private static final String USERNAME = "VigilanciaSanitaria";
    private static final String PASSWORD = "vigilancia";
    private static final String ROLE = "ADMIN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, Paths.QUEIXA).permitAll()
                .antMatchers(HttpMethod.GET,
                        Paths.QUEIXA_POR_ID,
                        Paths.UNIDADE_SAUDE_POR_BAIRRO,
                        Paths.UNIDADE_SAUDE_POR_ESPECIALIDADE,
                        Paths.MEDIA_UNIDADE_SAUDE)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter(Paths.LOGIN, authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(USERNAME)
                .password(PASSWORD)
                .roles(ROLE);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();

        corsConfiguration.setAllowedOrigins(ImmutableList.of("*"));
        corsConfiguration.setAllowedMethods(ImmutableList.of("*"));
        corsConfiguration.addExposedHeader(TOKEN_HEADER);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }
}