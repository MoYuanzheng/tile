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
 * (Container)实体类
 *
 * @author MoYz
 * @since 2021-03-15 16:42:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("相关")
public class Container implements Serializable {
    @ApiModelProperty(value = "$column.comment", required = true)
    private String id;
    @ApiModelProperty(value = "大尺寸包装追溯码", required = true)
    private String bigId;
    @ApiModelProperty(value = "小尺寸追溯码", required = true)
    private String smallId;
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

    public Container(
            String id,
            String bigId,
            String smallId,
            String remark
    ) {
        this.id = id;
        this.bigId = bigId;
        this.smallId = smallId;
        this.remark = remark;

    }

    public Container(
            String bigId,
            String smallId,
            String remark
    ) {
        this.bigId = bigId;
        this.smallId = smallId;
        this.remark = remark;

    }
}