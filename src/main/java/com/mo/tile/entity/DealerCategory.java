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
 * 分销商分类表(DealerCategory)实体类
 *
 * @author MoYz
 * @since 2021-03-16 22:26:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("分销商分类表相关")
public class DealerCategory implements Serializable {
    @ApiModelProperty(value = "区域经销代码", required = true)
    private String id;
    @ApiModelProperty(value = "中文名", required = true)
    private String cnName;
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

    public DealerCategory(
            String id,
            String cnName,
            String remark
    ) {
        this.id = id;
        this.cnName = cnName;
        this.remark = remark;

    }
}