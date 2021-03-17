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
 * 材料类图(MaterialCategory)实体类
 *
 * @author MoYz
 * @since 2021-03-16 22:26:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("材料类图相关")
public class MaterialCategory implements Serializable {
    @ApiModelProperty(value = "主键，材料代号", required = true)
    private String id;
    @ApiModelProperty(value = "名字", required = true)
    private String cnName;
    @ApiModelProperty(value = "品级", required = true)
    private Integer levels;
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

    public MaterialCategory(
            String id,
            String cnName,
            Integer levels,
            String remark
    ) {
        this.id = id;
        this.cnName = cnName;
        this.levels = levels;
        this.remark = remark;

    }
}