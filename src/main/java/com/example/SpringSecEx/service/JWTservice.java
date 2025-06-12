package com.example.SpringSecEx.service;

import org.springframework.stereotype.Service;

@Service
public class JWTservice {
    // This service can be used to handle JWT operations like token generation, validation, etc.
    
    public String generateToken() {
        // Logic to generate JWT token for the given username
        return  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
    }

    // public boolean validateToken(String token) {
    //     // Logic to validate the provided JWT token
    //     return token != null && token.startsWith("generatedTokenFor:"); // Placeholder implementation
    // }

}