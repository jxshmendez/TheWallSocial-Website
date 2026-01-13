package org.josh.climber.controller;

import org.josh.climber.DTO.auth.request.AuthRequestDTO;
import org.josh.climber.model.UserModel;
import org.josh.climber.model.UserRole;
import org.josh.climber.repository.UserRepository;
import org.josh.climber.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequestDTO request){
        if(userRepo.findByUsername(request.username()).isPresent()){
            return ResponseEntity.badRequest().body("Username already taken");
        } else if(userRepo.findByEmail(request.email()).isPresent()){
            return ResponseEntity.badRequest().body("Email already taken");
        }

        UserModel user = UserModel.builder()
                .username(request.username())
                .email(request.email()) //todo: Secure this
                .password(passwordEncoder.encode(request.password()))
                .userRole(UserRole.USER)
                .createdAt(LocalDateTime.now())
                .build();

        userRepo.save(user);
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request){
        UserModel user = userRepo.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(request.password(), user.getPassword())){
            return ResponseEntity.badRequest().body("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "userId", user.getUserId(),
                        "username", user.getUsername()
                )
        );

    }
}
