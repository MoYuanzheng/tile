package com.mo.tile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
public class TileApplicationTests {

    @Test
    public String setToken() {
        String token = String.valueOf(UUID.randomUUID());
        System.out.println("111111111111111");
        System.out.println(token);
        return token;
    }

    @Test
    public String yes() {
        System.out.println("666");
        return null;
    }
}
