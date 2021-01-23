package com.mo.tile.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author MoYz
 * @since 2021-01-23 17:20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product implements Serializable {

    private String id;
    private Integer type;
    private String batch;
    private Integer places;
    private Integer price;
    private String qrCode;
}