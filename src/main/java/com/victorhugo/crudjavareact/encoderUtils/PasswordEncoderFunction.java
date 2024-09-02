package com.victorhugo.crudjavareact.encoderUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@FunctionalInterface
public interface PasswordEncoderFunction {
    String encode(String password);

    static PasswordEncoderFunction bcryptEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder::encode;
    }

    static boolean matches(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);
    }
}