package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户实体类")
public class User implements Serializable {

    @ApiModelProperty(value = "账号", example = "admin")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("身份")
    private String roles;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("逻辑删除标志位")
    private Integer delFlag;

    @ApiModelProperty("乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
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