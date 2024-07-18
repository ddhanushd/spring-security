package com.investor.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
	public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String hashedPassword1 = passwordEncoder.encode("dhanush");
        String hashedPassword2 = passwordEncoder.encode("abc");
        
        System.out.println("Hashed password for 'dhanush': " + hashedPassword1);
        System.out.println("Hashed password for 'abc': " + hashedPassword2);
    }

}
