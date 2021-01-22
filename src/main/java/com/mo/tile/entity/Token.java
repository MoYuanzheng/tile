package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Token implements Serializable {
    @TableId("user_id")
    private String user_id;
    private String token;
    private Long token_time;

    public Token(String user_id) {
        this.user_id = user_id;
    }
}
