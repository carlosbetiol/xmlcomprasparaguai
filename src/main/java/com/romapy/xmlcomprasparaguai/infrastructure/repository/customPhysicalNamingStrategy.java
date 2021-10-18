package com.romapy.xmlcomprasparaguai.infrastructure.repository;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class customPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    public customPhysicalNamingStrategy(String tableName) {
        this.tableName = tableName;
    }

    private final String tableName;

    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        if (identifier == null) {
            return null;
        }

        return Identifier.toIdentifier(this.tableName);
    }

}
