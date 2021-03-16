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
 * 材料表(Material)实体类
 *
 * @author MoYz
 * @since 2021-03-16 17:50:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("材料表相关")
public class Material implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "商品代号，对应材料表主键", required = true)
    private String alias;
    @ApiModelProperty(value = "供货商", required = true)
    private String supplier;
    @ApiModelProperty(value = "剩余货物数量", required = true)
    private Integer surplus;
    @ApiModelProperty(value = "该批货物总重量", required = true)
    private Integer total;
    @ApiModelProperty(value = "截止日期时间戳", required = true)
    private String deadline;
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

    public Material(
            String id,
            String alias,
            String supplier,
            Integer surplus,
            Integer total,
            String deadline,
            String remark
    ) {
        this.id = id;
        this.alias = alias;
        this.supplier = supplier;
        this.surplus = surplus;
        this.total = total;
        this.deadline = deadline;
        this.remark = remark;

    }
}