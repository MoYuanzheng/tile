package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.*;

import java.io.Serializable;

/**
 * (Token)实体类
 *
 * @author MoYz
 * @since 2021-01-23 17:26:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Token implements Serializable {

    private String id;
    private String token;
    private Integer deadline;

    @Version
    private Integer version;

    public Token(String id, String token, Integer deadline) {
        this.id = id;
        this.token = token;
        this.deadline = deadline;
    }
}