package com.sdn.sdn_autenticador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SdnAutenticadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdnAutenticadorApplication.class, args);
    }

}
