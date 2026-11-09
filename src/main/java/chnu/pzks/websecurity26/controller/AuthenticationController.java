/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 09.11.2026
 * Course: Spring Security
 * Task №8. JWT
 */

package chnu.pzks.websecurity26.controller;

import chnu.pzks.websecurity26.model.dto.AuthenticationRequest;
import chnu.pzks.websecurity26.model.dto.AuthenticationResponse;
import chnu.pzks.websecurity26.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
