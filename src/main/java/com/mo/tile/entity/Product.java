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
 * 产品(Product)实体类
 *
 * @author MoYz
 * @since 2021-02-09 17:03:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("产品相关")
public class Product implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "产品型号", required = true)
    private Integer type;
    @ApiModelProperty(value = "批次号", required = true)
    private String batch;
    @ApiModelProperty(value = "单价", required = true)
    private Object price;
    @ApiModelProperty(value = "追溯二维码", required = true)
    private String qrCode;
    @ApiModelProperty(value = "备注")
    private String remark;


    public Product(
            String id,
            Integer type,
            String batch,
            Object price,
            String qrCode,
            String remark
    ) {
        this.id = id;
        this.type = type;
        this.batch = batch;
        this.price = price;
        this.qrCode = qrCode;
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