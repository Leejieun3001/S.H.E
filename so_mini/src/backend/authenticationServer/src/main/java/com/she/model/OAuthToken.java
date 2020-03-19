package com.she.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//토큰정보를 받을 모델 생성
public class OAuthToken {
	private String access_token;
	private String token_type;
	private String refresh_token;
	private long expires_in;
	private String scope;
}
