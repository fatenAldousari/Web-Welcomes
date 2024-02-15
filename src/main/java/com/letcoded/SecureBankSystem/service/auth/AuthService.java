package com.letcoded.SecureBankSystem.service.auth;

import com.letcoded.SecureBankSystem.bo.auth.LogoutResponse;
import com.letcoded.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.letcoded.SecureBankSystem.bo.auth.CreatLoginRequest;
import com.letcoded.SecureBankSystem.bo.auth.CreatSignupRequest;

public interface AuthService {

    void signup(CreatSignupRequest createSignupRequest);

    AuthenticationResponse login(CreatLoginRequest createLoginRequest);

    void logout(LogoutResponse logoutResponse);
}