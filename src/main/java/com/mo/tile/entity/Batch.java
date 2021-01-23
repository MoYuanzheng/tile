package com.mo.tile.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (Batch)实体类
 *
 * @author MoYz
 * @since 2021-01-23 17:20:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Batch implements Serializable {

    private String id;
    private Date creatTime;
    private Date completeTime;
    private Integer productType;
    private Integer total;
}