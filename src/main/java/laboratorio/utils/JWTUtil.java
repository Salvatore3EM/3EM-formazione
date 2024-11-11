package laboratorio.utils;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {

    private final String SECRET_KEY = "76bb849338db38e0ede3b8ae726373c42992152747c39e484f096b623946c8a265adde3a72c8177a70a8876694b9403f06d44decfcfe44be25f1078be0282239";

    // Metodo per generare il token
    public String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Valido per 1 ora
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Metodo per validare il token
    public boolean validateToken(String token, String username) {
        final String tokenUsername = extractUsername(token);
        return (username.equals(tokenUsername) && !isTokenExpired(token));
    }

    // Estrae lo username dal token
    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    // Verifica se il token è scaduto
    public boolean isTokenExpired(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }

    // Estrae i ruoli dal token
    public String extractRole(String token) {
        return (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("role");
    }
}
