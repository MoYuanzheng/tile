package com.mo.tile.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.*;

import java.io.Serializable;

/**
 * (Supplier)实体类
 *
 * @author MoYz
 * @since 2021-01-23 17:20:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Supplier implements Serializable {

    private String id;
    private String material;
    private String fullName;
    private String header;
    private String phone;
    private String address;

    @Version
    private Integer version;
}