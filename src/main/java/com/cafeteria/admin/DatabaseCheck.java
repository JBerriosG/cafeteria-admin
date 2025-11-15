package com.cafeteria.admin;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCheck implements CommandLineRunner{

    private final DataSource dataSource;

    public DatabaseCheck (DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Conexión exitosa a la base de datos");
    }

}
