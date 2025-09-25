/**
 * Provides the main application classes and configurations.
 *
 * <p>This package contains the core Spring Boot application class,
 * configuration classes, and main application components.</p>
 *
 * @author Anna Kovalevskaja
 * @version 1.0
 * @since 2025
 * main
 */

package com.fartone.cardapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserCardAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCardAppApplication.class, args);
    }

}
