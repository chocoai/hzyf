package com.cd.uap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by li.mingyang on 2018/4/24.
 */
@Configuration
public class JwtTokenConfig {
    @Bean
    public TokenStore jwtTokenStore(){
        return null;
    }

}
