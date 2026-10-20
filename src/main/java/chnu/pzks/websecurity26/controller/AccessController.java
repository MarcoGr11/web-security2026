/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 20.10.2026
 * Course: Spring Security
 * Task №5. Multi-user
 */

package chnu.pzks.websecurity26.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/access")
public class AccessController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "Hello, admin!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-user")
    public String helloUser() {
        return "Hello, user!";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/hello-man")
    public String helloMan() {
        return "Hello, man!";
    }
}
