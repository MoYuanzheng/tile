package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.Version;
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

    @Version
    private Integer version;

    public User(String id, String username, String pwd, String roles, String phone, String email, String remarks) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.roles = roles;
        this.phone = phone;
        this.email = email;
        this.remarks = remarks;
    }
}