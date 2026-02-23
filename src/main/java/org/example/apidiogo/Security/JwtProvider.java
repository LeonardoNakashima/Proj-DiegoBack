package org.example.apidiogo.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.apidiogo.Model.Admin;
import org.example.apidiogo.Model.Aluno;
import org.example.apidiogo.Model.Professor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms}")
    private long jwtExpirationMs;

    private Key key;

    private Key getKey() {
        if (key == null) {
            key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        }
        return key;
    }

    public String generateTokenAluno(Aluno aluno) {
        return Jwts.builder()
                .setSubject(String.valueOf(aluno.getMatricula()))
                .claim("role", "ROLE_ALUNO")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateTokenProfessor(Professor professor) {
        return Jwts.builder()
                .setSubject(professor.getUsuario())
                .claim("role", "ROLE_PROFESSOR")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateTokenAdmin(Admin admin) {
        return Jwts.builder()
                .setSubject(admin.getUsuario())
                .claim("role", "ROLE_ADMIN")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.err.println("Erro na validação: " + e.getMessage()); // Adicione este print temporário
            return false;
        }
    }

    public String getUsuarioFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getSubject();
    }
}
