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
 * 材料(Material)实体类
 *
 * @author MoYz
 * @since 2021-03-09 22:42:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("材料相关")
public class Material implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "中文名", required = true)
    private String cnName;
    @ApiModelProperty(value = "英文名", required = true)
    private String enName;
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
            String cnName,
            String enName,
            String remark
    ) {
        this.id = id;
        this.cnName = cnName;
        this.enName = enName;
        this.remark = remark;

    }
}