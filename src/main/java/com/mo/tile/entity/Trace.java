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
 * (Trace)实体类
 *
 * @author MoYz
 * @since 2021-03-12 21:15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("相关")
public class Trace implements Serializable {
    @ApiModelProperty(value = "主键-对应商品追溯码", required = true)
    private String id;
    @ApiModelProperty(value = "操作员", required = true)
    private Integer operationPerson;
    @ApiModelProperty(value = "操作时间", required = true)
    private Date operationTime;
    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "物流或者分销", required = true)
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
            Integer operationPerson,
            Date operationTime,
            String content,
            String type,
            String remark
    ) {
        this.id = id;
        this.operationPerson = operationPerson;
        this.operationTime = operationTime;
        this.content = content;
        this.type = type;
        this.remark = remark;

    }
}