package com.letcoded.SecureBankSystem.controller.authController;


import com.letcoded.SecureBankSystem.bo.auth.LogoutResponse;
import com.letcoded.SecureBankSystem.service.auth.AuthService;
import com.letcoded.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.letcoded.SecureBankSystem.bo.auth.CreatLoginRequest;
import com.letcoded.SecureBankSystem.bo.auth.CreatSignupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
@PostMapping("/signup")
    public ResponseEntity<String> creatUser(@RequestBody CreatSignupRequest creatSignupRequest) {
        try {
            authService.signup(creatSignupRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("user created");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error while creating");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody CreatLoginRequest creatLoginRequest){
        AuthenticationResponse response=authService.login(creatLoginRequest);
        HttpStatus status= HttpStatus.OK;
        if (response==null){
            status=HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void>logout(@RequestBody LogoutResponse logoutResponse){
        authService.logout(logoutResponse);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
