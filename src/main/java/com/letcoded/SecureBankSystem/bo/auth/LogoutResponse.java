package com.letcoded.SecureBankSystem.bo.auth;

public class LogoutResponse {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}
