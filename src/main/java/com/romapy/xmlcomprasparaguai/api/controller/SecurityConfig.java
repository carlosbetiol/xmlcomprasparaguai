package com.romapy.xmlcomprasparaguai.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Locale;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private static final String HAS_SONG_SERVICE_IPS = "hasIpAddress('172.16.8.250/32') or hasIpAddress('127.0.0.1/32')";

    @Value("${whitelist}")
    private String allow;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        StringBuilder whiteList = new StringBuilder();
        if(allow.toLowerCase().equals("all") || allow.equals("")) {
            whiteList = new StringBuilder("hasIpAddress('0.0.0.0/0')");
        } else {
            String[] arrOfIps = allow.split(" ");
            for (String s : arrOfIps) {
                whiteList.append(!whiteList.toString().equals("") ? " or " : "");
                whiteList.append("hasIpAddress('").append(s).append("')");
            }
        }

        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,"/comprasparaguai/**")
                .access(String.valueOf(whiteList));
    }
}
