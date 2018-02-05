package com.buster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackageClasses = { Buster.class, Jsr310JpaConverters.class })
public class BusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusterApplication.class, args);
    }
}
