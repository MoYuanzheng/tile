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
 * 大包装追溯码(Packet)实体类
 *
 * @author MoYz
 * @since 2021-03-15 15:34:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("大包装追溯码相关")
public class Packet implements Serializable {
    @ApiModelProperty(value = "主键，包裹追溯码", required = true)
    private String id;
    @ApiModelProperty(value = "包裹容量", required = true)
    private Integer size;
    @ApiModelProperty(value = "剩余容量", required = true)
    private Integer surplus;
    @ApiModelProperty(value = "使用标志位", required = true)
    private Integer useFlag;
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

    public Packet(
            String id,
            Integer size,
            Integer surplus,
            String remark
    ) {
        this.id = id;
        this.size = size;
        this.surplus = surplus;
        this.remark = remark;
    }

    public Packet(
            String id,
            Integer size,
            Integer surplus
    ) {
        this.id = id;
        this.size = size;
        this.surplus = surplus;
    }

    public Packet(
            String id,
            Integer size,
            Integer surplus,
            Integer useFlag,
            String remark
    ) {
        this.id = id;
        this.size = size;
        this.surplus = surplus;
        this.useFlag = useFlag;
        this.remark = remark;
    }
}