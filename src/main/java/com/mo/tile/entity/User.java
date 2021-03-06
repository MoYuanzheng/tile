package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户(User)实体类
 *
 * @author MoYz
 * @since 2021-02-09 16:33:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("用户相关")
public class User implements UserDetails {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "用户名 登录", required = true)
    private String username;
    @ApiModelProperty(value = "昵称 显示", required = true)
    private String nickname;
    @ApiModelProperty(value = "密码，最长 20 位", required = true)
    private String pwd;
    @ApiModelProperty(value = "权限", required = true)
    private String roles;
    @ApiModelProperty(value = "电话", required = true)
    private String phone;
    @ApiModelProperty(value = "电子邮箱", required = true)
    private String email;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty("短信验证码")
    private String code;
    @ApiModelProperty("短信验证失效时间")
    private Date deadline;
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
    @TableField(exist = false)
    private List<GrantedAuthority> authorities;

    public User(
            String id,
            String username,
            String nickname,
            String pwd,
            String roles,
            String phone,
            String email,
            String remark
    ) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.pwd = pwd;
        this.roles = roles;
        this.phone = phone;
        this.email = email;
        this.remark = remark;
    }

    public User(
            String id,
            String username,
            String nickname,
            String pwd,
            String roles,
            String phone,
            String email
    ) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.pwd = pwd;
        this.roles = roles;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}