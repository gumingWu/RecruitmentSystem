package com.recruit.server.util;

import com.recruit.server.model.Admin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT——Json Web Token
 */
public class JwtUtils {
    private static final String CLAIM_KEY_ADMIN = "claimAdmin";
    public static final String CLAIM_KEY_CREATED = "claimCreated";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 生成Jwt Token
     */
    public String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     *根据用户信息生成token
     */
    public String generateTokenByAdmin(Admin admin){
        Map<String, Object> claim = new HashMap<>();
        claim.put(CLAIM_KEY_ADMIN, admin);
        claim.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claim);
    }
}
