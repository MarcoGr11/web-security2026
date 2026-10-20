/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 07.10.2026
 * Course: Spring Security
 * Task №4. CSRF & Audit
 */

package chnu.pzks.websecurity26.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/api/v1/access/hello-admin").hasRole("ADMIN")
                        .requestMatchers("/api/v1/access/hello-user").hasRole("USER")
                        .requestMatchers("/api/v1/access/hello-man").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
        UserDetails user = User.builder().username("user").password("{noop}user").roles("USER").build();
        UserDetails superadmin = User.builder().username("superadmin").password("{noop}superadmin").roles("SUPERADMIN").build();
        return new InMemoryUserDetailsManager(admin, user, superadmin);
    }
}
