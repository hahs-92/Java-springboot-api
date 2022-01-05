package com.platzi.market.web.security;

import com.platzi.market.domain.service.PlatziUserDetailsService;
import com.platzi.market.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PlatziUserDetailsService service;
    private final JwtFilterRequest jwtFilterRequest;

    @Autowired
    public SecurityConfig(PlatziUserDetailsService service, JwtFilterRequest jwtFilterRequest) {
        this.service = service;
        this.jwtFilterRequest = jwtFilterRequest;
    }

    //indicar el user and password
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //vamos a desabilitar peticis cruzadas y permitir que se pueda
        //acceder a la ruta de authenticate
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**/authenticate")
                .permitAll()
                .anyRequest().authenticated()//todas las demas rut se deben authenticar
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//indicarle que es stateless

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean //spring va manager la gestion de auth con este metodo
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
