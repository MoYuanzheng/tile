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
 * 包装盒数量统计(PacketStatistics)实体类
 *
 * @author MoYz
 * @since 2021-03-15 16:56:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("包装盒数量统计相关")
public class PacketStatistics implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "容量", required = true)
    private Integer size;
    @ApiModelProperty(value = "剩余数量", required = true)
    private Integer surplus;
    @ApiModelProperty(value = "总共生产", required = true)
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

    public PacketStatistics(
            String id,
            Integer size,
            Integer surplus,
            Integer total,
            String remark
    ) {
        this.id = id;
        this.size = size;
        this.surplus = surplus;
        this.total = total;
        this.remark = remark;
    }
}