package org.elvira.backend.controller.auth;

import lombok.RequiredArgsConstructor;
import org.elvira.backend.entity.auth.AuthenticationRequest;
import org.elvira.backend.entity.auth.AuthenticationResponse;
import org.elvira.backend.entity.auth.RegisterRequest;
import org.elvira.backend.service.auth.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
