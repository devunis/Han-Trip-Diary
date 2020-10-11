package com.htd.dto;

public class JwtResponse {
    private final String jwt;

    public JwtResponse(String jwt) {
        this.jwt = "Bearer " + jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
