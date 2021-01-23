package com.mo.tile.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (Material)实体类
 *
 * @author MoYz
 * @since 2021-01-23 17:20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Material implements Serializable {

    private String id;
    private String cnName;
    private String enName;
}