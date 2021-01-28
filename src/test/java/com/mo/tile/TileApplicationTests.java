package com.mo.tile;

import com.mo.tile.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TileApplicationTests {

    UserMapper userMapper;

    @Test
    public Boolean delUser() {
        return userMapper.deleteById("admin") == 1;
    }
}
