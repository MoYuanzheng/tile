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
 * (TestTime)实体类
 *
 * @author MoYz
 * @since 2021-02-08 20:38:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("相关")
public class TestTime implements Serializable {

    @ApiModelProperty(value = "$column.comment")
    private String id;

    @ApiModelProperty(value = "$column.comment")
    private String names;

    @ApiModelProperty("备注")
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

    public TestTime(String id, String names) {
        this.id = id;
        this.names = names;
    }
}