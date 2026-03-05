package com.siv.api;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbPing implements CommandLineRunner {

    private final DataSource dataSource;

    public DbPing(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection c = dataSource.getConnection()) {
            System.out.println("✅ DB CONNECTED");
            System.out.println("URL = " + c.getMetaData().getURL());
            System.out.println("Driver = " + c.getMetaData().getDriverName());
        }
    }
}