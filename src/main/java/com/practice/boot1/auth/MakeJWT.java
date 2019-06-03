package com.practice.boot1.auth;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.practice.boot1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MakeJWT {
	private static final Date ISSUE_DATE;
	private static final Date EXPIRE_DATE;
	static {
		Calendar calendar = Calendar.getInstance();
		ISSUE_DATE = calendar.getTime();
		calendar.add(Calendar.DATE, 10);
		EXPIRE_DATE = calendar.getTime();
	}
	public static String makeJWT(String salt, UserInfoVO ui) {
		String jwt = JWT.create()
				.withIssuer(ui.getUiId())
				.withIssuedAt(ISSUE_DATE)
				.withExpiresAt(EXPIRE_DATE)
				.sign(Algorithm.HMAC256(salt));		
		log.info("jwt=>{}",jwt);
		return jwt;
	}
	public static void checkJWT(String tokken, String salt, UserInfoVO ui) {
		JWTVerifier verifier = JWT
				.require(Algorithm.HMAC256(salt))
				.withIssuer(ui.getUiId())
				.build();
		DecodedJWT decode = verifier.verify(tokken);
		log.info("decode=>{}",decode);
		log.info("issuer=>{}",decode.getIssuer());
		log.info("issue date=>{}",decode.getIssuedAt());
		log.info("expire date=>{}",decode.getExpiresAt());
	}
}

