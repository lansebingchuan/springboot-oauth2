package com.zht.jwt.util;

import com.zht.jwt.exception.UserNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    /**
     * jwt 密钥
     */
    private static String secret = "123456";

    /**
     * jwt 工具
     *
     * @param secret 加密密钥
     */
    public JwtUtil(@Value("${token.secret:123456}") String secret) {
        JwtUtil.secret = secret;
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims parseToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            throw new UserNotFoundException();
        }
        return claims;
    }


    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", "张海涛");
        String token = createToken(claims);
        System.out.println("生成的token: " + token);
        System.out.println("token解析：" + parseToken(token).toString());
    }

}
