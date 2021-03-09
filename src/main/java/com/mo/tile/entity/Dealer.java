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
 * 经销商(Dealer)实体类
 *
 * @author MoYz
 * @since 2021-02-09 17:03:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("经销商相关")
public class Dealer implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "别名", required = true)
    private String alias;
    @ApiModelProperty(value = "全称", required = true)
    private String fullName;
    @ApiModelProperty(value = "经销商等级，1 === 一级经销商", required = true)
    private Integer grade;
    @ApiModelProperty(value = "办公地址", required = true)
    private String address;
    @ApiModelProperty(value = "销售负责区域", required = true)
    private String area;
    @ApiModelProperty(value = "备注")
    private String remark;
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

    public Dealer(
            String id,
            String alias,
            String fullName,
            Integer grade,
            String address,
            String area,
            String remark
    ) {
        this.id = id;
        this.alias = alias;
        this.fullName = fullName;
        this.grade = grade;
        this.address = address;
        this.area = area;
        this.remark = remark;

    }
}