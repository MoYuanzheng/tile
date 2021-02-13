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
 * Token(Token)实体类
 *
 * @author MoYz
 * @since 2021-02-09 16:33:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("Token相关")
public class Token implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "UUID生成", required = true)
    private String token;
    @ApiModelProperty(value = "失效时间", required = true)
    private Integer deadline;
    @ApiModelProperty(value = "备注")
    private String remark;


    public Token(
            String id,
            String token,
            Integer deadline
    ) {
        this.id = id;
        this.token = token;
        this.deadline = deadline;
        this.remark = remark;

    }

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
}