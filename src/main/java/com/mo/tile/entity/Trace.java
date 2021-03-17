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
 * 追溯(Trace)实体类
 *
 * @author MoYz
 * @since 2021-03-17 11:20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("追溯相关")
public class Trace implements Serializable {
    @ApiModelProperty(value = "主键-对应商品追溯码", required = true)
    private String id;
    @ApiModelProperty(value = "商品ID或订单ID", required = true)
    private String productId;
    @ApiModelProperty(value = "操作员", required = true)
    private String operationPerson;
    @ApiModelProperty(value = "操作时间", required = true)
    private String operationTime;
    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "1物流、2装箱、3原材料映射", required = true)
    private String type;
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

    public Trace(
            String id,
            String productId,
            String operationPerson,
            String content,
            String type,
            String remark
    ) {
        this.id = id;
        this.productId = productId;
        this.operationPerson = operationPerson;
        this.content = content;
        this.type = type;
        this.remark = remark;
    }
}