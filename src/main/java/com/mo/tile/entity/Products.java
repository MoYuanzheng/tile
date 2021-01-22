package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * (Products)实体类
 *
 * @author mo
 * @since 2021-01-23 01:16:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Products implements Serializable {

    @TableId("product_id")
    private String product_id;
    private Integer product_type;
    private String product_batch;
    private Integer product_places;
    private Integer product_price;
    private String product_code;
}