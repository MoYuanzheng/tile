package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author MoYz
 * @since 2021-02-08 17:53:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("相关")
public class User implements Serializable {

    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "用户名 用于显示")
    private String username;
    @ApiModelProperty(value = "密码，最长 20 位")
    private String pwd;
    @ApiModelProperty(value = "权限")
    private String roles;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    @ApiModelProperty("备注")
    private String remark;

    public User(String id, String username, String pwd, String roles, String phone, String email, String remark) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.roles = roles;
        this.phone = phone;
        this.email = email;
        this.remark = remark;
    }

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
}