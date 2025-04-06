package com.pagos.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/users/").permitAll() // Permite acceso sin autenticación a esta ruta
                                .anyRequest().authenticated() // Requiere autenticación para otras rutas
                )
                .httpBasic(withDefaults()); // Habilita la autenticación básica con la configuración predeterminada
        return http.build();
    }

    // Ignorar ciertas rutas para la seguridad, en este caso "/api/users/**"
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/api/users/**");
    }
}
