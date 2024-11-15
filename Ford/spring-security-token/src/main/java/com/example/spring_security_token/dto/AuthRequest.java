package com.example.spring_security_token.dto;


import lombok.Builder;


public record AuthRequest(String username,String password) {}
