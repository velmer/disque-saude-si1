package com.ufcg.si1.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

class TokenAuthenticationService {

    private static final long   DAY_IN_MILLISECOND = 864_000_00;
    private static final long   EXPIRATION_TIME = DAY_IN_MILLISECOND;
    private static final String SECRET = "sVnJvzsXFU1XCEzU5ROrCOHYCA_D3WlWuz0TgBg85J4-KoYuxtBsLw9qDlkOhOIP";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String PREFIX_TO_REPLACE = "";
    private static final String HEADER_KEY = "Authorization";

    static void addAuthentication(HttpServletResponse res, String username) {
        String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        res.addHeader(HEADER_KEY, TOKEN_PREFIX + jwt);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_KEY);
        Authentication userAuthenticationToken = null;

        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, PREFIX_TO_REPLACE))
                    .getBody()
                    .getSubject();

            if (user != null)
                userAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, emptyList());
        }

        return userAuthenticationToken;
    }

}