package sv.edu.udb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.dto.AuthRequest;
import sv.edu.udb.dto.AuthResponse;
import sv.edu.udb.dto.RegisterRequest;
import sv.edu.udb.entity.User;
import sv.edu.udb.repository.UserRepository;
import sv.edu.udb.service.JwtService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //Login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest authRequest
    ) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authRequest.getUsername(),
                                authRequest.getPassword()
                        )
                );

        if(authentication.isAuthenticated()){
            var userDetails =
                    (User) authentication.getPrincipal();
            String jwtToken=
                    jwtService.generateToken(
                            userDetails
                    );
            String refreshToken=
                    jwtService.generateRefreshToken(
                            userDetails
                    );
            return ResponseEntity.ok(
                    new AuthResponse(
                            jwtToken,
                            refreshToken
                    )
            );
        }
        throw new UsernameNotFoundException(
                "Credenciales inválidas"
        );

    }

    //Registro

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest registerRequest
    ){
        if(userRepository.findByUsername(
                registerRequest.getUsername()
        ).isPresent()){
            return ResponseEntity.badRequest()
                    .body(
                            "Usuario ya existe"
                    );
        }

        User user=new User();

        user.setUsername(
                registerRequest.getUsername()
        );
        user.setPassword(
                passwordEncoder.encode(
                        registerRequest.getPassword()
                )
        );
        user.setFirstname(
                registerRequest.getFirstname()
        );
        user.setLastname(
                registerRequest.getLastname()
        );
        user.setAge(
                registerRequest.getAge()
        );
        userRepository.save(user);

        return ResponseEntity.ok(
                "Usuario registrado correctamente"
        );
    }
}