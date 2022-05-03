package com.rusetskiy.boxOffice.MyDialects;

import java.sql.Types;

public class PostgresDialectWithJson extends org.hibernate.dialect.PostgreSQL10Dialect{
    public PostgresDialectWithJson() {
        this.registerColumnType(Types.JAVA_OBJECT, "json");
    }
}
