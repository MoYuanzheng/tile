package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (Batch)实体类
 *
 * @author mo
 * @since 2021-01-23 01:14:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Batch implements Serializable {

    @TableId("batch_id")
    private Integer batch_id;
    private Date batch_creation;
    private Date batch_completion;
    private Integer batch_product_type;
    private Integer batch_total;
}