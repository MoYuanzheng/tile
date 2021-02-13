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
 * 供应商(Supplier)实体类
 *
 * @author MoYz
 * @since 2021-02-09 17:03:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("供应商相关")
public class Supplier implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "所供应材料", required = true)
    private String material;
    @ApiModelProperty(value = "供应商全称", required = true)
    private String fullName;
    @ApiModelProperty(value = "负责人名字", required = true)
    private String header;
    @ApiModelProperty(value = "联系电话", required = true)
    private String phone;
    @ApiModelProperty(value = "联系地址", required = true)
    private String address;
    @ApiModelProperty(value = "备注")
    private String remark;


    public Supplier(
            String id,
            String material,
            String fullName,
            String header,
            String phone,
            String address,
            String remark
    ) {
        this.id = id;
        this.material = material;
        this.fullName = fullName;
        this.header = header;
        this.phone = phone;
        this.address = address;
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