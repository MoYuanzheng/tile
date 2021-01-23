package com.mo.tile.entity;

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
}