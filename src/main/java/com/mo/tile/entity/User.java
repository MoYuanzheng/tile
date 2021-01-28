package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

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

    /**
     * 逻 辑 删 除 标 志 位
     */
    private Integer delFlag;

    /**
     * 乐 观 锁
     */
    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

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