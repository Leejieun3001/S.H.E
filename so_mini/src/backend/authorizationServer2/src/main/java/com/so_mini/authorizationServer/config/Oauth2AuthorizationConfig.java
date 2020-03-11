package com.so_mini.authorizationServer.config;

import com.so_mini.authorizationServer.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@EnableAuthorizationServer // 인증서버 활성화
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final DataSource dataSource;
    private final CustomUserDetailService userDetailService;

    @Value("${security.oauth2.jwt.signkey}")
    private String signKey;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()") //allow check token
                .allowFormAuthenticationForClients();
    }

    /**
     * 클라이언트 정보 주입 방식을 jdbcdetail로 변경
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
    }

//    /**
//     * 토큰 정보를 DB를 통해 관리한다.
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints.tokenStore(new JdbcTokenStore(dataSource)).userDetailsService(userDetailService);
//    }


//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
//        endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailService);
//    }
    /**
     * 토큰 발급 방식을 JWT 토큰 방식으로 변경한다. 이렇게 하면 토큰 저장하는 DB Table은 필요가 없다.
     *
     * @param endpoints
     * @throws Exception
     * refresh 토큰이 정상인지 확인하려면 회원 정보를 조회해봐야 하므로 다음과 같이
     * Oauth2AuthorizationConfig에 userDetailsService를 세팅해 줍니다.
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailService);
    }

//    /**
//     * jwt converter를 등록
//     *
//     * @return
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        return new JwtAccessTokenConverter();
//    }

    /**
     * jwt converter - signKey 공유 방식
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signKey);
        return converter;
    }

//    /**
//     * jwt converter - 비대칭 키 sign
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new FileSystemResource("src/main/resources/oauth2jwt.jks"), "oauth2jwtpass".toCharArray());
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2jwt"));
//        return converter;
//    }
}
