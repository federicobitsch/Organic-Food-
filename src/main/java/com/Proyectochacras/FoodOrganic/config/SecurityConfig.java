package com.Proyectochacras.FoodOrganic.config;

import com.Proyectochacras.FoodOrganic.service.CustomProductorDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    //proyecto finalizado

    private final CustomProductorDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomProductorDetailsService customProductorDetailsService, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customProductorDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para pruebas, habilítalo en producción

                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite el acceso a todas las URLs sin autenticación

                )
                .httpBasic(withDefaults()) // Se puede quitar si no deseas habilitar HTTP Basic
                .formLogin(form -> form
                        .loginPage("/login")  // Ruta de la página de login
                        .defaultSuccessUrl("/home", true)  // Redirige después del login
                        .permitAll()  // Permite acceso a la página de login
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")  // Redirige después de cerrar sesión
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
}
