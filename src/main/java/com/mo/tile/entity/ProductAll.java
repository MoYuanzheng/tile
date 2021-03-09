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
 * (ProductAll)实体类
 *
 * @author MoYz
 * @since 2021-03-09 22:42:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@ApiModel("相关")
public class ProductAll implements Serializable {
    @ApiModelProperty(value = "主键", required = true)
    private String id;
    @ApiModelProperty(value = "产品类别", required = true)
    private String type;
    @ApiModelProperty(value = "批次", required = true)
    private String batch;
    @ApiModelProperty(value = "生产日期", required = true)
    private Date manufactureDate;
    @ApiModelProperty(value = "质检日期", required = true)
    private Date inspectionDate;
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

    public ProductAll(
            String id,
            String type,
            String batch,
            Date manufactureDate,
            Date inspectionDate,
            String remark
    ) {
        this.id = id;
        this.type = type;
        this.batch = batch;
        this.manufactureDate = manufactureDate;
        this.inspectionDate = inspectionDate;
        this.remark = remark;
    }
}