package com.example.SpringSecurity.PasswordEncoder.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    private String secretKey = "";

    public JWTService(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256"); //mention the algorithm used
            SecretKey sk = keyGenerator.generateKey(); //generete key
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded()); //encode the generated key and assign value to string, which will be decoded when being used
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 *60 *10)) //for 10 mins
                .and()
                .signWith(getKey())
                .compact();
        // the generated jwt token can be verified in jwt.io website - it should give the username
    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); //convert string to byte[]
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        //extract username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final  Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return  extractClaim(token, Claims::getExpiration);
    }
}
