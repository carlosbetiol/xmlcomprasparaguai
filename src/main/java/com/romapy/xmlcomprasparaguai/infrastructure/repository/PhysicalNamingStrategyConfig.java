package com.romapy.xmlcomprasparaguai.infrastructure.repository;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhysicalNamingStrategyConfig {

    @Value("${table.name}")
    private String tableName;

    @Bean
    public PhysicalNamingStrategy physical() {
        return new customPhysicalNamingStrategy(tableName);
    }
}
