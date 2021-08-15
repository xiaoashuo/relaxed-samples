package com.relaxed.samples.security.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.relaxed.common.security.jwt.core.JwtTokenService;
import com.relaxed.common.security.jwt.exception.JwtVerifyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.NonceExpiredException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * @author Yakir
 * @Topic TokenServiceImpl
 * @Description
 * @date 2021/8/15 12:30
 * @Version 1.0
 */
public class TokenServiceImpl implements JwtTokenService {

	/**
	 * 刷新间隔5分钟
	 */
	private static final int tokenRefreshInterval = 300;

	@Override
	public String generateToken(UserDetails userDetails) {
		String username = userDetails.getUsername();
		Algorithm algorithm = Algorithm.HMAC256(username);
		// 设置1小时后过期
		Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
		return JWT.create().withSubject(username).withExpiresAt(date).withIssuedAt(new Date()).sign(algorithm);
	}

	@Override
	public String getSubject(String token) {
		return decodeToken(token).getSubject();
	}

	@Override
	public void verify(String token, UserDetails userDetails) throws JwtVerifyException {
		DecodedJWT decodedJWT = decodeToken(token);
		if (decodedJWT.getExpiresAt().before(Calendar.getInstance().getTime())) {
			throw new NonceExpiredException("Token expires");
		}
		try {
			String username = userDetails.getUsername();
			Algorithm algorithm = Algorithm.HMAC256(username);
			JWTVerifier verifier = JWT.require(algorithm).withSubject(username).build();
			verifier.verify(token);
		}
		catch (Exception e) {
			throw new JwtVerifyException("JWT token verify fail", e);
		}
	}

	@Override
	public boolean shouldTokenRefresh(String token) {
		Date issuedAt = decodeToken(token).getIssuedAt();
		LocalDateTime issueTime = LocalDateTime.ofInstant(issuedAt.toInstant(), ZoneId.systemDefault());
		return LocalDateTime.now().minusSeconds(tokenRefreshInterval).isAfter(issueTime);
	}

	private DecodedJWT decodeToken(String token) {
		return JWT.decode(token);
	}

}
