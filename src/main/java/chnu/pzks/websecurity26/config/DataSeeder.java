/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 09.11.2026
 * Course: Spring Security
 * Task №8. JWT
 */

package chnu.pzks.websecurity26.config;

import chnu.pzks.websecurity26.model.Role;
import chnu.pzks.websecurity26.model.User;
import chnu.pzks.websecurity26.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void seedUsers() {
        if (userRepository.count() != 0) {
            return;
        }
        userRepository.saveAll(List.of(
                user("1", "Admin", "admin", Role.ADMIN),
                user("2", "User", "user", Role.USER),
                user("3", "Superadmin", "superadmin", Role.SUPERADMIN)));
    }

    private User user(String id, String name, String login, Role role) {
        return User.builder()
                .id(id)
                .firstName(name)
                .lastName(name)
                .email(login + "@websecurity.local")
                .password(passwordEncoder.encode(login))
                .role(role)
                .build();
    }
}
