package org.kfokam48.gestiondestockbackend.controller.auth;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockbackend.dto.auth.AuthenticationRequest;
import org.kfokam48.gestiondestockbackend.dto.auth.AuthenticationResponse;
import org.kfokam48.gestiondestockbackend.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationControlleur {
    private final AuthService authService;

    public AuthenticationControlleur(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        // Logic to authenticate the user and generate a token
        String token = authService.authenticateUser(request);

        return ResponseEntity.ok(token);

    }
}
