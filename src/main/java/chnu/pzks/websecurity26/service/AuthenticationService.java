/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 09.11.2026
 * Course: Spring Security
 * Task №8. JWT
 */

package chnu.pzks.websecurity26.service;

import chnu.pzks.websecurity26.model.User;
import chnu.pzks.websecurity26.model.dto.AuthenticationRequest;
import chnu.pzks.websecurity26.model.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = (User) userDetailsService.loadUserByUsername(request.getEmail());
        Map<String, Object> extraClaims = Map.of("fullName", user.getFullName());
        String token = jwtService.generateToken(extraClaims, user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
