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
 * 订单批次表(Batch)实体类
 *
 * @author MoYz
 * @since 2021-03-15 09:54:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("订单批次表相关")
public class Batch implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "订单完成时间戳", required = true)
    private String completeTime;
    @ApiModelProperty(value = "产品型号", required = true)
    private Integer productType;
    @ApiModelProperty(value = "订单总数", required = true)
    private Integer total;

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

    public Batch(
            String id,
            String completeTime,
            Integer productType,
            Integer total,
            String remark
    ) {
        this.id = id;
        this.completeTime = completeTime;
        this.productType = productType;
        this.total = total;
        this.remark = remark;
    }

    public Batch(
            String id,
            Integer productType,
            Integer total,
            String remark
    ) {
        this.id = id;
        this.productType = productType;
        this.total = total;
        this.remark = remark;
    }
}