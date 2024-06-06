package az.edu.itbrains.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private CustomUserDetailService userDetailService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
                .csrf(c->c.disable())
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/dashboard/**").authenticated();
                    request.anyRequest().permitAll();
                })
                .formLogin(form -> {
                    form.loginPage("/login");
                    form.defaultSuccessUrl("/dashboard");
                    form.failureUrl("/login?auth=false");
                });

        return http.build();
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }




}
