package com.victorhugo.crudjavareact.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("crud-java-react")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.getExpiration())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e){
            throw new GenericApplicationException(e.getMessage(), e.getCause());
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("crud-java-react")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e){
            throw new GenericApplicationException(e.getMessage(), e.getCause());
        }

    }

    private Instant getExpiration(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
