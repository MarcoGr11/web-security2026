/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 20.10.2026
 * Course: Spring Security
 * Task №5. Multi-user
 */

package chnu.pzks.websecurity26.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello, security!";
    }
}
