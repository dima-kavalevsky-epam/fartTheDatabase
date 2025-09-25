// package com.fartone.usercardapp;
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
