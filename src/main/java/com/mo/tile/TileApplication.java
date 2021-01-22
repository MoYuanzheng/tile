package com.mo.tile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Naruto
 */
@MapperScan("com.mo.tile.mapper")
@SpringBootApplication
public class TileApplication {

    public static void main(String[] args) {
        SpringApplication.run(TileApplication.class, args);
    }

}
