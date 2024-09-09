package cl.semaluc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtTokenGenerator {
	@Value("${spring.application.name}")
	private String appName;
	@Value("${jwt.config.secret}")
	private String secretKey;
	
    public String execute(String username) {
         Algorithm algorithm = Algorithm.HMAC256(secretKey);

         return JWT.create()
                 .withIssuer(appName)            
                 .withSubject(username)               
                 .withIssuedAt(new Date())
                 .sign(algorithm);
    }

}
