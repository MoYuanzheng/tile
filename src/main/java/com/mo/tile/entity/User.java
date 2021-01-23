package com.mo.tile.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author MoYz
 * @since 2021-01-23 17:20:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    private String id;
    private String username;
    private String pwd;
    private String roles;
    private String phone;
    private String email;
    private String remarks;
}