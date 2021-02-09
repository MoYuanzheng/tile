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
 * (Supplier)实体类
 *
 * @author MoYz
 * @since 2021-02-09 15:20:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("相关")
public class Supplier implements Serializable {
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


    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "所供应材料")
    private String material;

    @ApiModelProperty(value = "供应商全称")
    private String fullName;

    @ApiModelProperty(value = "负责人名字")
    private String header;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty("备注")
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
}